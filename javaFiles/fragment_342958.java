cv.Mat opencv_matrix;
Matrix android_matrix;
if (opencv_matrix.isContiguous()) {
    android_matrix.setValues(cv.MatOfFloat(opencv_matrix.ptr()).toArray());
} else {
    float[] opencv_matrix_values = new float[9];
    // Undocumented .get(row, col, float[]), but seems to be bulk-copy.
    opencv_matrix.get(0, 0, opencv_matrix_values);
    android_matrix.setValues(opencv_matrix_values);
}