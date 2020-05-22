public static Integer[] myMethod(int []arr){ //notice the return type is Integer[] instead of int[]
    List<Integer> evens = new ArrayList<Integer>();
    for(int a : arr) {
        if(a%2 == 0) {
            evens.add(a);
        }
    }
    return evens.toArray(new Integer[evens.size()]);
}