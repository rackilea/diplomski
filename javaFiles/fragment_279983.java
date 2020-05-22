void setup() {

  //one-dimensional arrays are arrays of things
  int[] array1 = {1, 2, 3};
  int[] array2 = {4, 5, 6 };
  int[] array3 = {7, 8, 9};

  int[] array4 = {10, 11, 12};
  int[] array5 = {13, 14, 15};
  int[] array6 = {16, 17, 18};

  //two-dimensional arrays are arrays of arrays
  int[][] row1 = {array1, array2, array3};
  int[][] row2 = {array4, array5, array6};

  //three-dimensional arrays are arrays of arrays of arrays
  int[][][] array3d = {row1, row2};
}