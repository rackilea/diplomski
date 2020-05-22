public static Banana fromConfigurationFile(File configurationFile) {
  Validate.notNull(configurationFile, String.format(EXCEPTION_PATH_REFERENCE_IS_NULL, configurationFile));
  Validate.isTrue(configurationFile.exists(), String.format(EXCEPTION_PATH_DOES_NOT_EXIST, configurationFile.getAbsolutePath()));
  Validate.isTrue(configurationFile.isFile()), String.format(EXCEPTION_PATH_IS_NOT_A_FILE, configurationFile.getAbsolutePath()));
  // and more validation...

}