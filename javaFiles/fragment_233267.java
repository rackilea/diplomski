String path = System.getProperty("appproperty.properties", "");
if (new File(path).isFile()) {
    try (FileInputStream fileStream = new FileInputStream(path)) {
        Properties p = new Properties();
        p.load(fileStream);
        System.out.println("_username "+p.getProperty("_username"));
        System.out.println("_password "+p.getProperty("_password"));
    }
}