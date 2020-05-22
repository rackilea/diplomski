public static void main(String[] args) {
    List<Integer> myList = new LinkedList<>(Arrays.asList(4,7,8,23,41));
    Collections.sort(myList);
    while (myList.size() > 1) {
        myList.add(0, myList.remove(0) + myList.remove(0));
    }
    int finalSum = myList.get(0);
    System.out.println(finalSum);
}