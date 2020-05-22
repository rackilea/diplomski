Scanner scan = new Scanner(System.in);
int N = 3;  //Size of matrix, You can have user input this as well. 

int[][] matrix = new int[N][N];
for (int n=0; n<N; n++){  //Initialize Columns
    for (int column=0; column<N; column++){
        matrix[column][n] = scan.nextInt();  //Store based on column
    }
}
for (int i=0; i<N; i++){  //Sort columns
    Arrays.sort(matrix[i]);
}
//The following code is used to print your array properly by rows instead of columns 
for (int i=0; i<N; i++){
    for (int j=0; j<N; j++){
        System.out.print(matrix[j][i]+" ");
    }
    System.out.println();
}