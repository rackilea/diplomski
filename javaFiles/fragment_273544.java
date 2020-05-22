// Called on Unity Start()
public Texture2D GetCameraTexture() {
  IntPtr textureId = GetCameraTextureId();
  Texture2D cameraTexture = Texture2D.CreateExternalTexture(
      1080,
      1920,
      TextureFormat.RGBA32,
      false,
      false,
      GetTextureId());
  return cameraTexture;
}

private IntPtr GetCameraTextureId() {
  // Calls into Java getTextureName method.
}