Vector3f zAxis = Vector3f.sub(eyePos, targetPos, null);
zAxis.normalise();

Vector3f xAxis = Vector3f.cross(upVec, zAxis, null);
xAxis.normalise();

Vector3f yAxis = Vector3f.cross(zAxis, upVec, null);

Matrix4f inverseView = new Matrix4f();
inverseView.m00 = xAxis.x;  inverseView.m01 = xAxis.y;  inverseView.m02 = xAxis.z;  inverseView.m03 = 0.0f;
inverseView.m10 = yAxis.x;  inverseView.m11 = yAxis.y;  inverseView.m12 = yAxis.z;  inverseView.m13 = 0.0f;
inverseView.m20 = zAxis.x;  inverseView.m21 = zAxis.y;  inverseView.m22 = zAxis.z;  inverseView.m23 = 0.0f;
inverseView.m30 = eyePos.x; inverseView.m31 = eyePos.y; inverseView.m32 = eyePos.z; inverseView.m33 = 1.0f;