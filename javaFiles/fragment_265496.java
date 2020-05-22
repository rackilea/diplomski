public static void main(String[] args) throws Exception {

    int arrayOne[] = {1, 50, 100, 50, 100, 22, 23, 26};
    int arrayTwo[] = {1, 45, 22, 23, 52, 90, 100, 99};


    TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
    for (int i = 0; i < arrayTwo.length; i++)
        if (!map.containsKey(arrayTwo[i])) // if you want it to choose the first
            map.put(arrayTwo[i], i);

    int arrayThree[] = new int[arrayOne.length];

    for (int i = 0; i < arrayThree.length; i++) {
        int v = arrayOne[i];

        Integer h = map.higherKey(v - 1);
        Integer l = map.lowerKey(v);

        arrayThree[i] = map.get(l !=null && (h ==null || v - l < h - v) ? l : h);
    }

    System.out.println(Arrays.toString(arrayThree));
}