List<Timestamp> ts = new ArrayList<Timestamp>();
    Timestamp t = new Timestamp(new java.util.Date().getTime());

    for(int i=0;i<5;i++){
        t.setTime(t.getTime()-(7*24 * (long)60* (long)60) * (long)1000);
        System.out.println(t);
        ts.add(new Timestamp(t.getTime()));
    }