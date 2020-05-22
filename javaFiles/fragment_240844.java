class Sandbox {
    public static void main(String[] args) {
        int[][] test = new int[5][5];
        recursiveAssign(test,10);
        int numThatAreTen = 0;
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(test[i][j] == 10) numThatAreTen++;
            }
        }
        System.out.println(numThatAreTen);
    } // main

    static void recursiveAssign(int[][] arr, int value) {
        recursiveAssign0(arr,value,0,0);
    } // recursiveAssign

    static private void recursiveAssign0(int[][] arr, int value, int x, int y) {
        if(arr != null && x < arr.length && arr[x] != null && y < arr[x].length) {
            arr[x][y] = value;
            // now go down, and across
            recursiveAssign0(arr,value,x+1,y);
            recursiveAssign0(arr,value,x,y+1);
        } 
    } // recursiveAssign0

} // Sandbox