public static void main(String[] args) throws Exception {

    List<Integer> intList = new ArrayList<Integer>();
    intList.add(1);
    intList.add(2);
    intList.add(3);
    List<List<Integer>> myLists = listPermutations(intList);

    for (List<Integer> al : myLists) {
        String appender = "";
        for (Integer i : al) {
            System.out.print(appender + i);
            appender = " ";
        }
        System.out.println();
    }

}