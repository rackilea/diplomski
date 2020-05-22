while(rows.hasNext()){
    List list = new ArrayList(); // initialize the list here

    HSSFRow row=(HSSFRow)rows.next();
    System.out.println("\n");
    Iterator cells=row.cellIterator();
    while( cells.hasNext() ) {
        /* all your code seems fine here, just uncomment list.add(something) lines */
    }

    insertRowInDB(list); // insert the cells in your database
}