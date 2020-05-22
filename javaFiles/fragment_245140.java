float rotY = (float) Math.toRadians(180);

  Matrix4f transMat = new Matrix4f();
  transMat.rotate(rotY, new Vector3f(0.0f, 1.0f, 0.0f));

  Vector4f vecPosMod = new Vector4f(1.0f, 0.0f, 0.0f, 1.0f);
  Matrix4f.transform(transMat, vecPosMod, vecPosMod);