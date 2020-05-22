@ApiMethod(name = "insertRecordList")
public RecordList insertRecordList(RecordList records) {
    PersistenceManager mgr = getPersistenceManager();
    try {
        for(Record record : records.getRecords()){
            if(record.getSyncTime() == null)
                record.setSyncTime(new Date());
        }
        mgr.makePersistentAll(records.getRecords());
    } finally {
        mgr.close();
    }
    return records;
}