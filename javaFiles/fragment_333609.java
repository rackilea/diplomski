// create test list
ArrayList<Integer> arrList = new ArrayList<>();
for (int i = 1; i <= 13; i++) {
    arrList.add(i);
}

// clone
ArrayList<Integer> newArrList = new ArrayList<>();
for (int i = 0; i < 4; i++) {
    newArrList.addAll(arrList);
}