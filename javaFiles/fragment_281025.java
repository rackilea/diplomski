Bitmap img = BitmapFactory.decodeResource(context.getResources(), R.drawable.text);
int[] texId = new int[1];
GLES20.glGenTextures(1, texId, 0);
GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, texId[0]);
GLUtils.texImage2D(GLES20.GL_TEXTURE_2D, 0, img, 0);
GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, GLES20.GL_LINEAR);