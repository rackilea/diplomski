ArrayList<Integer[]> combinations = new ArrayList();
Iterator iter = combinationsIterator(4, 2);
while (iter.hasNext()) {
    int[] resultint = iter.next();
    Integer[] resultInteger = new Integer[2];
    for (int i = 0; i < 2; i++) {
        resultInteger[i] = Integer.valueOf(resultint[i]);
    }
    combinations.add(resultInteger);
}