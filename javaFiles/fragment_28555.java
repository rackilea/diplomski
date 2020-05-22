public class MainClass {

  static Properties properties= null;

  public static void main(String[] args) throws Exception{
// TODO Auto-generated method stub

  ReadPropertyFile readConfigFile= new ReadPropertyFile();

   properties = readConfigFile.loadPropertiess();
   }
}