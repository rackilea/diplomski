private int getVal (int[][] array, int x,int y) {

     try{
        return array[x][y];
    }catch(ArrayIndexOutOfBoundsException e){
        System.out.println ("AIOOB");
    } 
    return 0;
}