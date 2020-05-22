public static int columnsum(int[][] matrix){
System.out.println("Column Totals************************************");
int total = 0; // define total here
for (int column = 0; column<matrix[0].length; column++){

    for (int row = 0; row<matrix.length; row++){
        total += matrix[row][column];
    System.out.println("The sum of column "+column+" is: "+total);
    }
return total;
}