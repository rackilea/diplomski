public Matrix4f getTranslationMatrix(float x, float y, float z) {
    translationMatrix.m30 = x;
    translationMatrix.m31 = y;
    translationMatrix.m32 = z;
    return translationMatrix;
}