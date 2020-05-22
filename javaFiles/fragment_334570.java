Scanner scan = new Scanner(System.in);
int[] col1 = new int[3];
int[] col2 = new int[3];
int[] col3 = new int[3];
for (int i=0; i<3; i++){ //Store based on column not row
    col1[i] = scan.nextInt();
    col2[i] = scan.nextInt();
    col3[i] = scan.nextInt();
}
int[][] matrix = new int[3][3];
matrix[0] = col1;
matrix[1] = col2;
matrix[2] = col3;
for (int i=0; i<3; i++){  //Sort columns
    Arrays.sort(matrix[i]);
}
//The following code is used to print your array properly by rows instead of columns 
for (int i=0; i<3; i++){
    for (int j=0; j<3; j++){
        System.out.print(matrix[j][i]+" ");
    }
    System.out.println();
}