import java.util.Properties;

public class MyApp {

  public static void main(String[] args) throws IOException {
    Properties prop = new Properties();
    prop.load(MyApp.class.getClassLoader().getResourceAsStream("log4j.properties"));

    System.out.println("Value=" + prop.getProperty("LOG"));
  }
}