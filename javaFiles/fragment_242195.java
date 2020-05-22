public static void dostuff(String word1, String word2) {
    boolean sub = false;

    ArrayList<String> list1 = new ArrayList<String>();
    ArrayList<String> list2 = new ArrayList<String>();
    ArrayList<String> list3 = new ArrayList<String>();
    for (int i = 0; i < word1.length(); i++) {
        list1.add(word1.split("")[i]);
    }
    for (int i = 0; i < word2.length(); i++) {
        list2.add(word2.split("")[i]);
    }

    if (list1.size() >= list2.size()) {
        for (String i : list2) {
            if (list1.contains(i)) {
                list1.remove(i);
                list3.add(i);
            }
        }
        if (list2.containsAll(list3) && list2.size() == list3.size()) {
            sub = true;
        }
    } else if (list2.size() > list1.size()) {
        for (String i : list1) {
            if (list2.contains(i)) {
                list2.remove(i);
                list3.add(i);
            }
            if (list1.containsAll(list3) && list1.size() == list3.size()) {
                sub = true;
            }
        }
    }
    System.out.println(sub);
}