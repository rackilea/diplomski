public class Matrix<E> {
    public static void main(String[] args) {
        Integer [][] x = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {0, 1, 0}};
        Matrix<Integer> y = new Matrix<Integer>(x);
        System.out.println(y.getRows());
        System.out.println(y.getColumns());

        System.out.println("before: " + y);
        Integer [][] values = y.getMatrix();
        values[0][0] = 10000;
        System.out.println("after : " + y);
    }
    private E[][] matrix;
    public Matrix(E[][] matrix) {this.matrix = matrix;}
    public E[][] getMatrix() {return matrix;}
    public int getRows(){return matrix.length;}
    public int getColumns(){return matrix[0].length;}
    public String toString()
    {
        StringBuilder builder = new StringBuilder(1024);
        String newline = System.getProperty("line.separator");

        builder.append('[');
        for (E [] row : matrix)
        {
            builder.append('{');
            for (E value : row)
            {
                builder.append(value).append(' ');
            }
            builder.append('}').append(newline);
        }
        builder.append(']');

        return builder.toString();
    }
}