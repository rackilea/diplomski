List<String> lst1 = getList1();
    List<String> lst2 = getList2();
    lst1.addAll(lst2);
    Set<String> set = new HashSet<String>(lst1);
    lst1 = new ArrayList<String>();
    lst1.addAll(set);
    lst1.sort(Comparator.<String>naturalOrder());
    for(String item: lst1) {
        System.out.println(item);
    }