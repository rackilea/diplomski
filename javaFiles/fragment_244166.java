/* This method loads the log4j.xml file from local directory */
public static void loadLog4jXml(){
        try{
             DOMConfigurator.configure( "C:\MyFirstJavaExecJar\log4j.xml");
        }
        catch(Exception e){
          System.out.println("There is a problem about log4J file loading");
        }
    }