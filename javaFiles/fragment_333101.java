List<List<String>> WPL = new ArrayList<List<String>>();
    List<String> WP = new ArrayList<String>();

    WP.add("A");
    WP.add("B");
    WPL.add(WP);

    WP = new ArrayList<String>();

    WP.add("C");
    WP.add("D");
    WPL.add(WP);

    for(List<String> a : WPL) {
        System.out.println(a.indexOf(a));

        for (String i : a)
        {
            System.out.println(i);
        }

    }