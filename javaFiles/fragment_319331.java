import com.documentum.com.DfClientX;
import com.documentum.com.IDfClientX;
import com.documentum.fc.client.*;
import com.documentum.fc.common.DfException;
import com.documentum.fc.common.IDfLoginInfo;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MedicalDevicesReport {

private static int j = 0;

public static void main(String[] args) throws DfException {

    String chronicleId;

    ArrayList<String> author = new ArrayList<>();

    IDfSessionManager sessionManager = getSessionManager("docbase", "user", "password");
    IDfSession dfSession = sessionManager.getSession("docbase");

    System.out.println(dfSession);

    IDfQuery idfquery = new DfQuery();
    IDfCollection collection;

    try {

        String dql = "select distinct r_object_id, object_name, title, authors, domain, primary_group, subgroup, artifact_name, r_version_label," +
                "a_status, r_creation_date, i_chronicle_id from cd_quality_gmp_approved (all)  where r_creation_date between " +
                "DATE('07/04/2018 00:00:00','mm/dd/yyyy hh:mi:ss') and DATE('07/05/2018 23:59:59','mm/dd/yyyy hh:mi:ss') order by r_creation_date";

        idfquery.setDQL(dql);
        collection = idfquery.execute(dfSession, IDfQuery.DF_READ_QUERY);

        int i = 1;

        File file = new File("C:\\SubWay TRC\\fetched_reports\\mdreport.xlsx");

        while(collection != null && collection.next()) {
            chronicleId = collection.getString("i_chronicle_id");
            author.add(collection.getString("authors"));
            executeWorkflowAudit(dfSession, collection, idfquery, chronicleId, author, i, file);
            i++;
        }

    } finally {
        cleanup(sessionManager, dfSession);
    }
}

private static void executeWorkflowAudit(IDfSession dfSession, IDfCollection attributeCollection, IDfQuery idfquery, String chronicleId, ArrayList<String> author,
                                         int i, File file) throws DfException {

    IDfCollection collection;

    String documentId, documentName, title, domain, primaryGroup, subGroup, artifactName, versionLabel, status, creationDate,
            versionNum = null, is_current;

    ArrayList<String> reviewer = new ArrayList<>();
    ArrayList<String> formatReviewer = new ArrayList<>();
    ArrayList<String> approver = new ArrayList<>();

    ArrayList<String> approvalCompletionTime = new ArrayList<>();

    String authorsF, reviewersF, formatReviewersF, approversF;
    String approvalCompletionTimeStamps;

    int wfAbortCount = 0;

    String dql = "select a.r_object_id, a.audited_obj_id, a.event_name as event_name, a.object_name as workflow_name, " +
            "doc.object_name as document_name, ra.child_label as document_version, a.owner_name as supervisor_name, " +
            "w.tracker_state as task_state, w.start_date as date_sent, a.user_name as task_performer, a.time_stamp as " +
            "task_completion_time, a.string_2 as outcome, a.event_source as event_source, a.string_3 as delegation_from, " +
            "a.string_4 as delegation_to from dm_audittrail a, d2c_workflow_tracker w, dm_relation ra, dm_sysobject doc " +
            "where a.audited_obj_id in (select w.r_object_id from d2c_workflow_tracker w where r_object_id in (select " +
            "distinct w.r_object_id from dm_relation r, d2c_workflow_tracker w where r.relation_name = 'D2_WF_TRACKER_DOCUMENT' " +
            "and r.child_id = '" + chronicleId + "' and r.parent_id=w.r_object_id)) and a.audited_obj_id=w.r_object_id and " +
            "ra.parent_id=w.r_object_id and a.audited_obj_id=ra.parent_id and ((a.event_name='d2_workflow_sent_task' and " +
            "a.user_name not in (select user_name from dm_audittrail b where b.event_name in ('d2_workflow_rejected_task', " +
            "'d2_workflow_forwarded_task', 'd2_delegation_delegated_task', 'd2_workflow_delegated_task', 'd2_workflow_added_note', " +
            "'d2_workflow_aborted') and b.audited_obj_id=a.audited_obj_id)) or (a.event_name in ('d2_workflow_rejected_task', " +
            "'d2_workflow_forwarded_task', 'd2_workflow_added_note', 'd2_workflow_aborted') and a.string_2 is not nullstring) or " +
            "(a.event_name in ('d2_delegation_delegated_task','d2_workflow_delegated_task', 'd2_workflow_added_note', " +
            "'d2_workflow_aborted'))) and doc.i_chronicle_id=ra.child_id and ra.child_label not In ('CURRENT',' ') order by 1 desc";

    idfquery.setDQL(dql);
    collection = idfquery.execute(dfSession, IDfQuery.READ_QUERY);

    while(collection != null && collection.next()) {
        String supervisorName = collection.getString("supervisor_name");
        author.add(supervisorName);

        if(collection.getString("event_name").equals("d2_workflow_aborted")) {
            wfAbortCount++;
        }

        if(collection.getString("event_source").equals("Review")) {
            reviewer.add(collection.getString("task_performer"));
            continue;
        }

        if(collection.getString("event_source").equals("Format Review")) {
            if(collection.getString("task_performer").contains("grp_wf_")) {
                continue;
            } else {
                formatReviewer.add(collection.getString("task_performer"));
                continue;
            }
        }

        if((collection.getString("event_source").equals("First Approval-no Sig")) ||
                (collection.getString("event_source").equals("First Approval")) ||
                (collection.getString("event_source").equals("Second Approval-no Sig")) ||
                (collection.getString("event_source").equals("Second Approval")) ||
                (collection.getString("event_source").contains("Approval"))) {
            approver.add(collection.getString("task_performer"));
            approvalCompletionTime.add(collection.getString("task_completion_time"));
        }
    }

    documentId = attributeCollection.getString("r_object_id");
    documentName = attributeCollection.getString("object_name");
    title = attributeCollection.getString("title");
    domain = attributeCollection.getString("domain");
    primaryGroup = attributeCollection.getString("primary_group");
    subGroup = attributeCollection.getString("subgroup");
    artifactName = attributeCollection.getString("artifact_name");
    versionLabel = attributeCollection.getString("r_version_label");
    status = attributeCollection.getString("a_status");
    creationDate = attributeCollection.getString("r_creation_date");

    String temp = versionLabel;
    String[] parts = temp.split("(?<=\\D)(?=\\d\\.?\\d)");
    if(parts.length > 1) {
        versionNum = parts[1];
        is_current = parts[0];
    } else {
        is_current = parts[0];
    }
    String versionLabelF = versionNum + " " + is_current;

    List<String> authors = author.stream().distinct().collect(Collectors.toList());
    List<String> reviewers = reviewer.stream().distinct().collect(Collectors.toList());
    List<String> formatReviewers = formatReviewer.stream().distinct().collect(Collectors.toList());
    List<String> approvers = approver.stream().distinct().collect(Collectors.toList());

    List<String> approvalCompletionTimeStamp = approvalCompletionTime.stream().distinct().collect(Collectors.toList());

    authorsF = authors.toString().substring(1, authors.toString().length() - 1);
    reviewersF = reviewers.toString().substring(1, reviewers.toString().length() - 1);
    formatReviewersF = formatReviewers.toString().substring(1, formatReviewers.toString().length() - 1);
    approversF = approvers.toString().substring(1, approvers.toString().length() - 1);

    approvalCompletionTimeStamps = approvalCompletionTimeStamp.toString().substring(1, approvalCompletionTimeStamp.toString().length() - 1);

    author.clear();
    reviewer.clear();
    formatReviewer.clear();
    approver.clear();

    approvalCompletionTime.clear();

    Workbook workbook = null;

    try {
        if (!file.exists()) {
            if (!file.toString().endsWith(".xls")) {
                workbook = new XSSFWorkbook();
                workbook.createSheet();
            }
        } else {
            workbook = WorkbookFactory.create(new FileInputStream(file));
            workbook.createSheet();
        }
    } catch(IOException ioe) {
        ioe.printStackTrace();
    }

    Row row;
    try {
        Sheet sheet = workbook.getSheetAt(j);
        int last_row = sheet.getLastRowNum();
        System.out.println(last_row);
        row = sheet.createRow(++last_row);

        Map<Integer, Object[]> data = new HashMap<>();
        data.put(i, new Object[] {documentId, documentName, title, domain, primaryGroup, subGroup, artifactName, versionLabelF,
                status, creationDate, authorsF, reviewersF, formatReviewersF, approversF, approvalCompletionTimeStamps, wfAbortCount});

        Set<Integer> key_set = data.keySet();

        for(Integer key: key_set) {
            Object[] obj_arr = data.get(key);
            int cell_num = 0;
            for(Object obj: obj_arr) {
                Cell cell = row.createCell(cell_num++);
                if(obj instanceof String) {
                    cell.setCellValue((String)obj);
                }
            }
        }

        FileOutputStream out = new FileOutputStream("C:\\SubWay TRC\\fetched_reports\\mdreport.xlsx", false);
        workbook.write(out);
        out.close();
        System.out.println("Data added successfully");

    } catch (IOException  e) {
        e.printStackTrace();
    } finally {
        if(collection != null) {
            collection.close();
        }
    }
}

private static IDfSessionManager getSessionManager(String docbase, String userName, String password) throws DfException {

    IDfClientX clientX = new DfClientX();
    IDfClient client = clientX.getLocalClient();

    IDfSessionManager sessionManager = client.newSessionManager();

    IDfLoginInfo loginInfo = clientX.getLoginInfo();
    loginInfo.setUser(userName);
    loginInfo.setPassword(password);

    sessionManager.setIdentity(docbase, loginInfo);

    return sessionManager;
}

public static void cleanup(IDfSessionManager sessionManager, IDfSession session) {

    if(sessionManager != null && session != null) {
        sessionManager.release(session);
    }
}