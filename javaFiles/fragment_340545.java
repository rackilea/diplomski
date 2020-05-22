public final static String envt,port,cpy_key;

static {
    Properties prop = new Properties();
    String propFileName = "properties/environment.properties";
    try{
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propFileName);
        System.out.println(inputStream);
        if (inputStream != null) {
           prop.load(inputStream);
           envt = prop.getProperty("envt");
           port = prop.getProperty("port");
           cpy_key = prop.getProperty("cpy_key");
          System.out.println("http://"+envt+"/netprofile/");  
          //Original Login Link
          /*        Constants.driver.get("http://"+prop.getProperty("user").replaceAll("\\s","")+":"+NP_Decrypt.getPassword().replaceAll("\\s","")+"@"+envt+"/netprofile/");
          inputStream.close();*/
          //Added for Local Testing
          user = prop.getProperty("user");
         password = prop.getProperty("password");

        } else {
         throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }
}

    public void TestDriver(){
         Constants.driver.get("http://" + user + ":" + password + "@" + envt + "/test/");


//  mdbc = new ManageDBConnection();
    //con = mdbc.CreateConnection();
}