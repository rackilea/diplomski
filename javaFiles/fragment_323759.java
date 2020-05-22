long l = 1479912701805l;
    Calendar c = Calendar.getInstance();
    c.setTimeInMillis(l);
    System.out.println(c.getTime());
    l -= l% (1000*60*60*24);
    c.setTimeInMillis(l);
    System.out.println(c.getTime());