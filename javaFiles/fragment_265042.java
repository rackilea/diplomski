public Result generateFile(String virtualfile_id,
                           int page) {
    List<TransactionRecord> transactionRecords = TransactionRecord.find.where()
        .ilike("virtualfile", "1") //set to "1" for testing
        .order().asc("id")
        .findPagedList(page, 25)
        .getList();
    return ok(toJson(transactionRecords));
}