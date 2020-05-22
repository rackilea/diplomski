public static void main(String[] args) {
    Map<String, List<String>> invertedindex = new HashMap<String, List<String>>();
    List<String> myList = new ArrayList<>();
    myList.add("firstitem");
    myList.add("seconditem");
    invertedindex.put("book", myList);
    invertedindex.put("book2", myList);
    int count_ = Collections.frequency(invertedindex.values(), myList);
    System.out.println(count_);
}