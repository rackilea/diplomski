String strAppName = null;
    try {

        FileInputStream fileInputStream = new FileInputStream("resources/config.properties");
        configProperties.load(fileInputStream);        
        strAppName = configProperties.getProperty("appName");
        //System.out.println(strAppName);
        fileInputStream.close(); // better in finally block ?? /* http://en.wikipedia.org/wiki/.properties */
    } catch (Exception ex){
        //TODO
        System.out.println("Exception: " + ex);
    }