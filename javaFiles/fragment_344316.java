final int DUPLICATE_AMOUNT = 3; // if you want the created array 3 times as big as the original

List<Integer> list = getMyList(); //original list 
List<Integer> fullRandom = new ArrayList<Integer>();
fullRandom.addAll(list);
for (int i = 1; i < DUPLICATE_AMOUNT; i++) {
    List<Integer> randomList = new ArrayList<Integer>();
    randomList.addAll(list);
    Collections.shuffle(randomList);
    fullRandom.addAll(randomList);
}