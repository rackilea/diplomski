public static int[] arraysMatching(int[] s1, int[] s2) {

    ArrayList<Integer> storage = new ArrayList<>();
    //for (int i = 0; i <= s1.length; i++) {
    //wrong. change <= to  < or better:
    for (int i : s1) {

        //for (int j = 0; j <= s2.length; j++) {
        //wrong. change <= to  < or better:
        for (int j : s2) {
            if (j == i) {
                storage.add(j);
                break;
            }
        }
    }

    //if you can use streams do
    //return  storage.stream().mapToInt(i->(int)i).toArray();

    //alternatively
    int[] returnArray = new int[storage.size()];
    for(int i=0; i< storage.size(); i++) {
        returnArray[i]=storage.get(i);
    }
    return returnArray;
}