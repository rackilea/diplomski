public static void main(String[] args){
    int[] toAdd = {5,7,10,-1};
    DynamicArrayOfInts d = new DynamicArrayOfInts(2);
    for(int i : toAdd){
        d.add(i);
        System.out.println(d);
    }
}