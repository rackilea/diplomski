String propfile = System.getProperty(configFile);
if (propfile != null) {
 // read in file
  new File(propfile);
 ...
} else {
  // read in file from classpath
  getClass.getResource("/configfile.xml")
}