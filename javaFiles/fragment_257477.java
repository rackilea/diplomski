public static void main(String[] args) {
    List<String> myList = new ArrayList<>();
    myList.add("eventB");
    myList.add("eventB");
    myList.add("eventA");
    myList.add("eventB");
    myList.add("eventA");
    myList.add("eventA");
    myList.add("eventA");
    myList.add("eventA");
    myList.add("eventA");
    myList.add("eventC");
    myList.add("eventD");
    myList.add("eventC");
    Map<String, Integer> countEventMap = new HashMap<String, Integer>();
    for (String event : myList) {
        if (countEventMap.get(event) != null) {
            countEventMap.put(event, countEventMap.get(event) + 1);
        } else
            countEventMap.put(event, 1);
    }

}