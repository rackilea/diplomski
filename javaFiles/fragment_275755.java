public static void main(String[] args) {
    int[] A = new int[]{2,9,8,13};
    int[] B = new int[]{5,3,1,11,4};
    System.out.println(findMe(A, B));
}

private static List<List<Integer>> findMe(int[] A, int[] B) {

    List<List<Integer>> solutions = new ArrayList<List<Integer>>();
    Arrays.sort(A);
    if (A[A.length - 1] > 9) { //if the greatest is greater than 9
        for (int a1 : A) { //for all the values in A
            Collection<List<Integer>> solution = findMeNow(B, a1);
            solutions.addAll(solution);
        }
    }
    return solutions;
}

private static Collection<List<Integer>> findMeNow(int[] B, int a1) {
    List<List<Integer>> lists = new ArrayList<List<Integer>>(); //list of all possible combinations
    Set<List<Integer>> solutions = new HashSet<List<Integer>>(); //list of all possible combinations

    for (int b1 : B) {
        int currentSize = lists.size();
        for (int index = 0; index < currentSize; index++) {
            //for each sub list, create a copy, add the new element and add it to the mother list
            List<Integer> list = lists.get(index);
            List<Integer> copyList = new ArrayList<>(list);
            copyList.add(b1);
            lists.add(copyList); 
        }
        lists.add(new ArrayList<>(Arrays.asList(a1, b1)));

        //Then check the sum for each of the resulting lists
        for (List<Integer> list : lists) {
            int sum = 0;
            for (Integer value : list) {
                sum += value;
            }
            if (sum % 13 == 0) {
                solutions.add(list);
            }
        }
    }
    return solutions;
}