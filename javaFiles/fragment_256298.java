private int[] reverseArray(int [] array1){
        int index=array1.length;
        int [] array2 = new int[index];
        for(int i:array1){
            array2[index-1]= i;
            index--;
        }
        return array2;    
}