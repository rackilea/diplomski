package com.inlet.ifserver;

import java.util.*;
class RecordLog {
    String recordID;
    String refNo;
    String baseRefNo;
    RecordLog parent;
    RecordLog child;

    RecordLog(String recordID, String refNo, String baseRefNo) {
        this.recordID = recordID;
        this.refNo = refNo;
        this.baseRefNo = baseRefNo;
    }
}

public class HelloWorld {
    public static void main(String []args){
        List<RecordLog> logList = new ArrayList<RecordLog>();
        Map<String, List<RecordLog>> recordLogMap = new HashMap<String, List<RecordLog>>();
        RecordLog record1 = new RecordLog("1","A","B");
        RecordLog record2 = new RecordLog("2","B","C");
        RecordLog record3 = new RecordLog("3","C","");
        RecordLog record4 = new RecordLog("4","D","");
        RecordLog record5 = new RecordLog("5","E","");
        logList.add(record1);
        logList.add(record2);
        logList.add(record3);
        logList.add(record4);
        logList.add(record5);

        // First, make an index for easy look up of each record by refNo
        Map<String, RecordLog> index = new HashMap<>();
        for (RecordLog rec : logList)
            index.put(rec.refNo, rec);

        // Now doubly link the records into a set of linked lists
        for (RecordLog rec : logList)
            if (rec.baseRefNo.length() > 0) {
                RecordLog parent = index.get(rec.baseRefNo);
                parent.child = rec;
                rec.parent = parent;
            }

        // Now, find the top of each linked list by processing the records without children. Walk
        // the parent links to build each list of records in a chain.  Once the chain's list is built,
        // record it in recordLogMap
        for (RecordLog rec : logList)
            if (rec.child == null) {
                List<RecordLog> records = new ArrayList<>();
                records.add(rec);
                RecordLog p = rec;
                while (p.parent != null) {
                    records.add(p.parent);
                    p = p.parent;
                }
                recordLogMap.put(rec.refNo, records);
            }

        // Now print the results
        for (String refNo : recordLogMap.keySet()) {
            List<RecordLog> records = recordLogMap.get(refNo);
            System.out.println(refNo);
            for (RecordLog rec : records)
                System.out.println(String.format("  %s", rec.refNo));
        }
    }

}