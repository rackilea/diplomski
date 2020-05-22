Integer[][] arr = { { 1, 3, 5, 3, 1 }, { 3, 5, 6, 5, 1 }, 
        { 7, 2, 3, 5, 0 }, { 12, 1, 5, 3, 0 }, { 20, 6, 3, 6, 1 }, 
        { 20, 7, 4, 7, 1 } };
System.out.println(Arrays.deepToString(arr));
List<List<Integer>> al = new ArrayList<>();
for (Integer[] inArr : arr) {
    al.add(Arrays.asList(inArr));
}
System.out.println(al);