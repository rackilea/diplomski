List<String[][]> list1 = new ArrayList<String[][]>();
    String[][] s1 = {{"1", "2"}, {"1", "2"}};
    String[][] s2 = {{"3", "4"}, {"3", "4"}};
    list1.add(s1);
    list1.add(s2);

    List<String[][]> list2 = new ArrayList<String[][]>();
    String[][] s3 = {{"1", "2"}, {"1", "2"}};
    String[][] s4 = {{"3", "4"}, {"3", "4"}};
    list2.add(s3);
    list2.add(s4);

    boolean isEqual = Arrays.deepEquals(list1.toArray(), list2.toArray());

    System.out.println(isEqual);//will  print true.