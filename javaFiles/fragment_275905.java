Set set = new HashSet();
    ArrayList list = new ArrayList();
    ArrayList list2 = new ArrayList(); //etc
    Object[] array = new Object[]{};
    Object[] array2 = new Object[]{}; // etc
    set.addAll(list);
    set.addAll(list2);
    set.addAll(Arrays.asList(array));
    set.addAll(Arrays.asList(array2));
    // Call addAll as many times as you like