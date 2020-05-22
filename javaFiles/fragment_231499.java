public static int columnsum(int[][] matrix){
System.out.println("Column Totals************************************");
for (int column = 0; column<matrix[0].length; column++){
    int total = 0; // total is defined within the for loop you cannot access it outside the for loop
    for (int row = 0; row<matrix.length; row++){
        total += matrix[row][column];
    System.out.println("The sum of column "+column+" is: "+total);
    }
return total; // Java do not know the total variable since it's already got destroyed after the for loop got terminated
}