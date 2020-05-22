public class Matrix {
    int[][] a;
    int rowNum;
    int colNum;

    //...
    public Matrix(Matrix b) {
       a=new int[b.getRowNum()][b.getColNum()];
       this.rowNum = b.getRowNum();
       this.colNum = b.getColNum();
    }

    public int getRowNum() {
       return this.rowNum;
    }


}