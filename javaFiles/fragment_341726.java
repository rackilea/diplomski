private static final String PUBLIC_IMAGE_DIRECTORY_RELATIVE_PATH = "public/images/";

  static File getImageAsset(String relativePath) throws ResourceNotFoundException {
     final String path = PUBLIC_IMAGE_DIRECTORY_RELATIVE_PATH + relativePath;
     final File file = new File(path);
     if (!file.exists()) {
       throw new ResourceNotFoundException(String.format("Asset %s not found", path));
     }
     return file;
  }