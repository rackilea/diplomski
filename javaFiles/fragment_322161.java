public class Main {
    public static void main(String[] args) {
        Properties prop = new Properties();
        try {
            prop.load(Main.class.getClassLoader().getResourceAsStream("config.properties"));
            String propertyValue = prop.getProperty("project.searchkey");
            System.out.println(propertyValue);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}