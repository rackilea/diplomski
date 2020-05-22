public class MatrixMaker {

private int rows;
private int columns;
private double[][] matrix;

public MatrixMaker(int m, int n){
    rows = m;
    columns = n;
    matrix = new double[rows][columns];

}