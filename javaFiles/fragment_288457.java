List<Integer> firstList = new ArrayList<>();
//add numbers to firstList

List<Integer> secondList = new ArrayList<>();

for(Integer i : firstList) {
    if((i % 2) == 0) {
        secondList.add(i * i);
     }
}