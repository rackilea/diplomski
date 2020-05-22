Matrix modelM= new Matrix();
Matrix.setRotateM(modelM, 0, mAngle, 0f, 0f, 1.0f);

Matrix viewM = new Matrix();
Matrix.setLookAtM(viewM, 0, 0, 0, 5f, 0f, 0f, 0f, 0f, 10.0f, 0.0f);

Matrix.multiplyMM(mModelMatrix, 0, viewM, 0, modelM, 0);
Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mModelMatrix, 0);