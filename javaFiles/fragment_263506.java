Properties config = null;
// try load config file from pre-defined location, first attempt
config = read("config/config.xml");
// if nothing is here, load config file from classpath, default.
if (config == null)
  config = read("src/main/resources/config.xml");