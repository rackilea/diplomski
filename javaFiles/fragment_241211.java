BasicDBList dblist = new BasicDBList();
    // create arraylist to use
    ArrayList<String> alist = new ArrayList<String>();
    alist.add("blip");
    alist.add("bloop");
    alist.add("blap");

    dblist.addAll(alist); 

    System.out.println(dblist);
}