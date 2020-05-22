final int dim1 = 2;
final int dim2 = 3;
final int dim3 = 4;
final int[][][] myArray = new int[dim1][dim2][dim3];

int i1 = 0;
int i2 = 0;
int i3 = 0;
for (long i = 0; i < ((long) dim1 * dim2 * dim3); i++) {
    System.out.println(i1 + "," + i2 + "," + i3);
    i3++;
    if (i3 == dim3) {
        i3 = 0;
        i2++;
        if (i2 == dim2) {
            i2 = 0;
            i1++;
        }
    }
}