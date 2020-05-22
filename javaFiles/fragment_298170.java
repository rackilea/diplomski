Iterator i = queque.entrySet().iterator();
    while(i.hasNext()) {
        Map.Entry<String, String> me = i.next();
        if (me.getKey() == "quattro") break;
        System.out.println(me.getKey() + ": " + me.getValue());
    }