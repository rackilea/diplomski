Properties properties = new Properties();

properties.load(new FileInputStream("file1.properties"));

Properties properties2 = new Properties();
properties2.load(new FileInputStream("file2.properties"));

properties.putAll(properties2);