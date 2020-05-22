private static int getProductBuildNumber(Path artefactFilePath) throws IOException{
   try(FileSystem zipFileSystem = FileSystems.newFileSystem(artefactFilePath, null)){
      Path versionPropertiesPath = zipFileSystem.getPath("/version.properties");
      Properties versionProperties = new Properties();
      try (InputStream is = Files.newInputStream(versionPropertiesPath)){
          versionProperties.load(is);
      }
      return Integer.parseInt(versionProperties.getProperty("product.build.number"));
   }
}