try {
        Properties prop = new Properties();
        String propFileName = "test.properties";
        inputSecretStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        if (inputSecretStream != null) {
            prop.load(inputSecretStream);
        } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }

        String jsonArray = prop.getProperty("jsonArray");
        String jsonArray2= prop.getProperty("jsonArray2");
    } catch (Exception e) {
        System.out.println("Exception: " + e);
    } finally {
        inputSecretStream.close();
    }