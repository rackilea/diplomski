public LPLogCompressor(final String logProcessorInstallPath, final File logLocationsSource,
                         final String desiredArchive) throws IOException {
    this.desiredArchive = desiredArchive + DOT + getDateTimeStampFormat() + ZIP;
    logLocations = getLogLocations(logProcessorInstallPath, logLocationsSource);
    enableLogCompression();
  }

  private static void enableLogCompression() {
    TConfig.get().setArchiveDetector(
        new TArchiveDetector(TArchiveDetector.NULL, new Object[][]{
            {"zip", new OverrideZipDriver(IOPoolLocator.SINGLETON)},}));
    TConfig.push();
  }