public ArrayList<CreditMemo> searchRecentCreditMemos()
        throws Exception {
    TransactionSearch transactionsSearch = new TransactionSearch();
    TransactionSearchBasic transactionSearchBasic = new TransactionSearchBasic();
    CustomerSearchBasic custSearchBasic = new CustomerSearchBasic();

    Calendar startDate = Calendar.getInstance();
    startDate.add(Calendar.DAY_OF_MONTH, -1);
    Calendar endDate = Calendar.getInstance();

    // Create criteria
    com.netsuite.webservices.platform.core_2014_1.SearchDateField searchDateField = new com.netsuite.webservices.platform.core_2014_1.SearchDateField();
    searchDateField
            .setOperator(com.netsuite.webservices.platform.core_2014_1.types.SearchDateFieldOperator.within);
    searchDateField.setSearchValue(startDate);
    searchDateField.setSearchValue2(endDate);

    transactionSearchBasic.setLastModifiedDate(searchDateField);

    transactionsSearch.setBasic(transactionSearchBasic);
    transactionsSearch.setCustomerJoin(custSearchBasic);

    SearchResult result = port.search(transactionsSearch);
    ArrayList<CreditMemo> creditMemoList = new ArrayList<>();

    if (result.getStatus().isIsSuccess()) {
        RecordList recordList = result.getRecordList();
        Record[] records = recordList.getRecord();

        if (records != null && records.length != 0) {
            for (int i = 0; i < records.length; i++) {
                if (records[i] instanceof CreditMemo) {
                    CreditMemo creditMemo = (CreditMemo) records[i];
                    creditMemoList.add(creditMemo);
                }
            }
        }
    }

    return creditMemoList;
}