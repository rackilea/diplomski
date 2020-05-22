public static void main(String[] args) {
    Map<int[], Double> mapVectFunc = new LinkedHashMap<int[], Double>();
    int[] t1 = { 1, 0, 0, 1 };
    int[] t2 = { 1, 1, 0, 0 };
    int[] t3 = { 1, 0, 1, 1 };
    mapVectFunc.put(t1, 26.0);
    mapVectFunc.put(t2, 1.0);
    mapVectFunc.put(t3, 6767.0);
    ArrayList<int[]> ll = miZrodzicowIpotomstwa(mapVectFunc, 2);

    int c = 0;
    for (int[] i : ll) {
        System.out.println("Array" + c++);
        for (int j : i) {
            System.out.println(j);
        }
    }   
}