ArrayList<String> rs = new ArrayList<>();
    rs.add("Hello#World");
    rs.add("Foo#Bar#Beckom");

    String [] t = new String[0];
    for(int i=0;i<rs.size();i++) {
        String [] newT = rs.get(i).split("#");
        String [] result = new String[newT.length+t.length];
        System.arraycopy(t, 0, result, 0,  t.length);
        System.arraycopy(newT, 0, result, t.length, newT.length);
        t = result;
    }

    for(int i=0;i<t.length;i++) {
        System.out.println(t[i]);
    }