// Option 1: print in String - preferred
public void testA(ArrayList<String> list) {
    for(String str : list) testA(str);
}

public void testA(String s) {
    System.out.println(s);
}



// Option2: print in List - not so preferred
public void testA(ArrayList<String> list) {
    for(String str : list) System.out.println(str);
}

public void testA(String s) {
    ArrayList<String> list = new ArrayList<String>();
    list.add(s);
    testA(list);
}