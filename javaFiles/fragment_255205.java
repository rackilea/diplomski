public static void main(final String[] args)
{
    Matrix matrix = new Matrix(3, 4);
    matrix.show();

    matrix.rotateColumn(2);
    matrix.show();
}