public static void main(String[]args){
Scanner input = new Scanner(System.in);
System.out.print("Enter the value of matrix: ");
int n = input.nextInt();

int [][] matrix = new int [n][n];

matrix[0][0]=0;  //you have forgotten the first value
for (int i = 1; i < matrix.length; i++) {
    matrix[0][i] = matrix[0][i -1] + n;
    //initializing the first line
}

for(int i = 1; i < matrix.length; i++){
    for (int j = 0; j < matrix.length; j++){
    matrix[i][j] = matrix[i -1][j] + 1;
    }

    // re-loop to display but this time start with i=0
   for(int i = 0; i < matrix.length; i++){
    for (int j = 0; j < matrix.length; j++){
     System.out.print(matrix[i][j] + " ");
    }

        System.out.println();

}

        input.close();
}