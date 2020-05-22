Matrix4f.m00 = 2.0f/(right-left);
Matrix4f.m01 = 0.0f;
Matrix4f.m02 = 0.0f;
Matrix4f.m03 = 0.0f;

Matrix4f.m10 = 0.0f;
Matrix4f.m11 = 2.0f/(top-bottom);
Matrix4f.m12 = 0.0f;
Matrix4f.m13 = 0.0f;

Matrix4f.m20 = 0.0f;
Matrix4f.m21 = 0.0f;
Matrix4f.m22 = -2.0f/(far-near);
Matrix4f.m23 = 0.0f;

Matrix4f.m30 = -(right+left)/(right-left);
Matrix4f.m31 = -(top+bottom)/(top-bottom);
Matrix4f.m32 =   -(far+near)/(far-near);
Matrix4f.m33 = 1.0f;