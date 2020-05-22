String fileLocation = abcd("internal property file");

            Properties properties = new Properties();
        FileInputStream fis = new FileInputStream(fileLocation );
        properties.load(fis);
        fis.close();

        acd = (String)properties.get("acd");