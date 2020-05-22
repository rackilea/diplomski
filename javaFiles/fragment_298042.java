final int dim1 = 2;
final int dim2 = 3;
final int dim3 = 4;
final int[][][] myArray = new int[dim1][dim2][dim3];

for (long i = 0; i < ((long) dim1 * dim2 * dim3); i++) {
    long idx = i;
    final int i3 = (int) (idx % dim3);
    idx /= dim3;
    final int i2 = (int) (idx % dim2);
    idx /= dim2;
    final int i1 = (int) idx;
    System.out.println(i1 + "," + i2 + "," + i3);
}