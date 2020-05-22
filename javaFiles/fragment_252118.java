List<String> list = new ArrayList<String>();
    list.add("Alice");
    list.add("Bob");

    String[] strArray = list.toArray(new String[0]);
    for (String str : strArray) {
        System.out.println(str);
    }

    Object[] objArray = list.toArray();
    for (Object obj : objArray) {
        String str = (String) obj;
        System.out.println(str);
    }