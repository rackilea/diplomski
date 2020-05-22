public Result generateFile(String virtualfile_id) {
    List<TransactionRecord> transactionRecords = TransactionRecord.find.where()
        .ilike("virtualfile", "1") //set to "1" for testing
        .orderBy("id asc")
        .findPagedList(0, 25)
        .getList();
    return ok(toJson(transactionRecords));
}