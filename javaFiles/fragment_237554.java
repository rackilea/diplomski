//the object's default forward size without any transformations
Vector3f forward = new Vector3f(0.0f, 0.0f, 1.0f);

//rotation axis
Vector3f axis = new Vector3f();
axis.cross(forward, inter);
axis.normalize();

//New rotation matrix to be applied
Matrix4f rotationMatrix = new Matrix4f();
rotationMatrix.setIdentity();
rotationMatrix.setRotation(new AxisAngle4f(axis, forward.angle(inter)));