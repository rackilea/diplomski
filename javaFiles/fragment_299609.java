public List<List<Integer>> create4(List<Integer> dice) {
    List<List<Integer>> listOf4s = new ArrayList<List<Integer>>();
    for(Integer num : dice) {
        List<Integer> dice2 = new ArrayList<Integer>(dice);
        dices2.remove(num);
        listOf4s.add(dices2);
    }
    return listOf4s;
}