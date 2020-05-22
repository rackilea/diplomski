File pathToGeckoDriver = new File("/path/to/geckodriver/executable");
File pathToFirefoxBinary = new File("/path/to/firefox/executable");

# Custom profile folder to keep the minidump files
Path basedir = FileSystems.getDefault().getPath("/tmp");
String tmp_dir_prefix = ".selenium";
Path tmp_dir = Files.createTempDirectory(basedir, tmp_dir_prefix);

# Use the above folder as custom profile
FirefoxBinary ffBinary = new FirefoxBinary(pathToFirefoxBinary);
ffBinary.addCommandLineOptions("-profile");
ffBinary.addCommandLineOptions(tmp_dir.toString()); # Use the above folder as custom profile

WebDriver driver = new FirefoxDriver(
           new GeckoDriverService.Builder()
           .usingFirefoxBinary(ffBinary)
           .usingPort(2828) # hard-code the Marionette port so geckodriver can connect
           .usingDriverExecutable(pathToGeckoDriver))
           .build()
);

# Your test code which crashes Firefox