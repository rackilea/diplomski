CustomerSearch customerSrch = new CustomerSearch();
        SearchResult searchResult = _port.search(customerSrch);
        System.out.println(searchResult.getTotalRecords());
        RecordList rl = searchResult.getRecordList();
        for (int i = 0; i <searchResult.getTotalRecords()-1; i++) {
            Record r = rl.getRecord(i);
            System.out.println("Customer # " + i);
            Customer testcust = (Customer)r;
            System.out.println("First Name: " + testcust.getFirstName());
        }