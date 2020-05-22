// Called on app resume.
public void resume() {
  mSession.resume(mConfig);
  mSession.setCameraTextureName(mTextureName[0]);
}

// Called on each Unity MonoBehaviour.Update().
public void renderFrame() {
  try {
    mSession.update();
  } catch (CameraException e) {
    Log.w(TAG, "Error when updating session", e);
  }
}

public int getTextureName() {
  mTextureName = new int[1];
  GLES20.glGenTextures(1, mTextureName, 0);
  GLES20.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, mTextureName[0]);
  return mTextureName[0];
}