Properties prop = new Properties();
    try {
        prop.load(new FileInputStream("config.properties"));
            System.out.println(prop.getProperty("destinationPDF"));
        System.out.println(prop.getProperty("destination"));
        System.out.println(prop.getProperty("fileList"));

    } catch (IOException ex) {
        ex.printStackTrace();
    }