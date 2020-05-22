Quat4d orientation;
Vector3d position;
double scale;
...
public void applyMatrix(GL2 gl) {
  Matrix4d matrix = new Matrix4d(orientation, position, scale);
  double[] glmatrix = new double[] {
    matrix.m00, matrix.m10, matrix.m20, matrix.m30,
    matrix.m01, matrix.m11, matrix.m21, matrix.m31,
    matrix.m02, matrix.m12, matrix.m22, matrix.m32,
    matrix.m03, matrix.m13, matrix.m23, matrix.m33,
  };
  gl.glMatrixMode(GL2.GL_MODELVIEW);
  gl.glLoadMatrixd(glmatrix, 0);
}