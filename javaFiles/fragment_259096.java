List<String> l = new ArrayList<String>();
    l.add("1");
    ListIterator<String> i = l.listIterator();
    i.add("2");
    while (i.hasPrevious()) {
        i.previous();
    }
    i.add("3");
    System.out.println(l);