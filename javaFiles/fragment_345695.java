@Override
public void applyTranslations(int uniformLocation) {
    viewMatrix = new Matrix4f();
    Matrix4f.rotate(MatrixUtils.degreesToRadians(pitch), new Vector3f(1, 0, 0), viewMatrix, viewMatrix);
    Matrix4f.rotate(MatrixUtils.degreesToRadians(yaw), new Vector3f(0, 1, 0), viewMatrix, viewMatrix);
    Matrix4f.rotate(MatrixUtils.degreesToRadians(roll), new Vector3f(0, 0, 1), viewMatrix, viewMatrix);
    Matrix4f.translate(new Vector3f(-x, -y, -z), viewMatrix, viewMatrix);
    viewMatrix.store(matrix44Buffer); matrix44Buffer.flip();
    glUniformMatrix4(uniformLocation, false, matrix44Buffer);
}