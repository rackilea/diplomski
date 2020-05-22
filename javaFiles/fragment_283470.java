public static void main(String[] args) {
    HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();
    String sent = "EGInnovations located in seven countries in the world";
    String[] words = sent.split(" ");
    int len = 0;
    List<String> stringList;
    for (String word : words) {
        len = word.length();

        stringList = map.get(len);
        if (stringList == null) {
            stringList = new ArrayList<String>();
            map.put(len, stringList);
        }
        stringList.add(word);
    }

    if (!map.isEmpty()) {
        System.out.println("Full length map : \n" + map); //Printing full length map
        System.out.println();
        List<Integer> lengthList = new ArrayList<Integer>(map.keySet());

        System.out.println("Minimum Length : " + Collections.min(lengthList));
        System.out.println("Minimum Length Words : " + map.get(Collections.min(lengthList)));

        System.out.println("\nMax Length : " + Collections.max(lengthList));
        System.out.println("Max Length Words : " + map.get(Collections.max(lengthList)));
    }
}