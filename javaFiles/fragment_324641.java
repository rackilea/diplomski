private static ArrayList<Integer> selsort(ArrayList<Integer> array){
    int i = 0;
    int len = array.size();
    for (i = 0; i < len - 1; i++) {
        int imin = i;
        for (int j = i + 1; j < len; j++) {
            if (array.get(j) < array.get(imin)) {
                imin = j;
            }
        }
        Collections.swap(array,i,imin);      
    }
    System.out.println(array);
    return array;
}