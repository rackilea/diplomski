private Vector4f toEyeCoords(Vector4f ndcCoords)
{
    Matrix4f invertedProjection = projectionMatrix.invert(new Matrix4f());
    Vector4f eyeCoords = invertedProjection.transform(clipCoords);

    return new Vector4f(eyeCoords.x/eyeCoords.w, eyeCoords.y/eyeCoords.w, eyeCoords.z/eyeCoords.w, 0.0f);
}