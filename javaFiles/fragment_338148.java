public class UsableSwingWorkerThread extends SwingWorker<ResultSet, Object> {

JTable table;
String query;


public UsableSwingWorkerThread(JTable table, String query) {
    this.table = table;

    this.query = query;

}

@Override
protected ResultSet doInBackground() throws Exception {

    return DatabaseFunctionClass.con.prepareStatement(query).executeQuery();
}

void loadTable(TableModel tb) {
    new UsableDefaultLoadTable(tb, table);
}

@Override
protected void done() {
    try {
        loadTable(DbUtils.resultSetToTableModel(get()));            
    } catch (Exception ignore) {
        StaticAccess.showMassageDialog(StaticAccess.mainFrame, "Fail to load. try again later..", ignore);
    }
}