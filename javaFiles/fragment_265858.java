File file = new File("myprops.txt");
    Properties properties = new Properties();

    try (InputStream in = new FileInputStream (file)) {
         properties.load (in);
    }

    String myValue = (String) properties.get("myKey");
    System.out.println (myValue);