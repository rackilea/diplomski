public class Properties {

    private static Map<String, DeveloperPaths> properties = create();

    private static Map<String, DeveloperPaths> create() {

        Map<String, DeveloperPaths> properties = new HashMap<String, DeveloperPaths>();

        properties.put("mike", new DeveloperPaths(
                "C:\\programmer_MIKE\fileA.txt", 
                "C:\\programmer_MIKE\fileB.txt")
                );

        properties.put("bill", new DeveloperPaths(
                "/Users/BILL/Desktop/fileA.txt", 
                "/Users/BILL/Desktop/fileB.txt")
                );

        return properties;
    }

    public static File FileA()
    {
        String user = System.getProperty("user.name");
        return properties.get(user).fileA;
    }

    public static File FileB()
    {
        String user = System.getProperty("user.name");
        return properties.get(user).fileB;
    }

}

 class DeveloperPaths {
    public File fileA;
    public File fileB;

    public DeveloperPaths(String pathA, String pathB) {
        fileA = new File(pathA);
        fileB = new File(pathB);
    }
}