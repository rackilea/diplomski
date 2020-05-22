public static ArrayList<Integer> getArrayList(int[] a){
    ArrayList<Integer> retList = new ArrayList<Integer>();
    for (int i : a){ 
        retList.add(i); 
    }
    return retList;
}