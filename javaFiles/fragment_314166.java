int[][][][] array=new int[5][5][5][5];
array[1][2][3][4]=42;
array[4][3][2][1]=1234;
TreeMap<IntBuffer, Integer> sparse=toMap(array);
sparse.forEach((index,value)-> {
    for(int ix:index.array()) System.out.print("["+ix+']');
    System.out.println("="+value);
});