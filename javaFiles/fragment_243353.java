//call your method resultSetToArrayList here
     List<Map> list = (List<Map>) resultSetToArrayList(rs);

    //loop the list
    for(Map r: list) {
        System.out.println("row data: ");
        final Iterator columnIterator = r.keySet().iterator();
        while(columnIterator.hasNext()) {
            final Object next = columnIterator.next();
            System.out.println("\tColumn: " + next + " / Value: " + r.get(next));
        }
    }