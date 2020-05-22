System.out.println(y);
// If the above printed something like:
// "FLOAT tensor with shape [1]"
// then you can get the values using:
float[] vector = y.copyTo(new float[1]);

// If the shape was something like [2, 3]
// then you can get the values using:
float[][] matrix = y.copyTo(new float[2][3]);