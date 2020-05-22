ListIterator<String> iter = myList.listIterator();
    while(iter.hasNext()){
        String url = (String) iter.next();
        String insert="INSERT into test (url) values (?)";
        prepstmt = conn.prepareStatement(insert);
        prepstmt .setString(r++, myURL);
    }