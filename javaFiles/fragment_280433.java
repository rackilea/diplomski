public static void main(String[] args) {
    int[][] arr = new int[4][];
    arr[0] = new int[4];
    arr[1] = new int[2];
    arr[2] = new int[1];
    arr[3] = new int[3];

    int counter = 1;
    int i = 0, j = 0; // Initialize vars for while loops

    //fill arr numbers from 1 to 10     
    while(i<arr.length){
        while(j<arr[i].length){
            arr[i][j] = counter++;
            j++; // Increment as in for loops
        }
        i++; // Increment as in for loops
        j = 0; // Restart j to the next outer loop step
    } 

    i = 0; // Reset i for outer loop
    // No need to j=0 since when the above loop ends, j will reset to 0

    while(i<arr.length){
        System.out.print(" arr [ " + i + " ] = ");
        while(j<arr[i].length){
            System.out.print(arr[i][j] + " ");
            j++; // Increment as in for loops
        }
        i++; // Increment as in for loops
        j = 0; // Same objective as in the loop above
        System.out.println(" ");
    }
}