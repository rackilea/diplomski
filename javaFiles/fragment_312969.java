mCam = Camera.open();
Camera.Parameters p = mCam.getParameters();
p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
mCam.setParameters(p);
mPreviewTexture = new SurfaceTexture(0);
try {
   mCam.setPreviewTexture(mPreviewTexture);
} catch (IOException ex) {
   // Ignore
}
mCam.startPreview();