public class ReadPropertyFile {

 public Properties  loadPropertiess() throws IOException{

// Read configuration properties file

   String projdir = System.getProperty("user.dir");
   String propfilepath = projdir+"\\configuration\\"+"conf.properties";
   Properties p = new Properties();
 p.load(new FileInputStream(propfilepath ));

   String url  = p.getProperty("URL");
  System.out.println(url); // It is returning me a value corresponding to key "test"
  String driverFilePath = p.getProperty("DRIVER_FILE_PATH");
  System.out.println(driverFilePath);
  String testSuite  = p.getProperty("TEST_SUITE");
   System.out.println(testSuite);
   return p;
} }