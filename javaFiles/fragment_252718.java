Properties prop = new Properties();

//read using input stream
InputStream in = getClass().getResourceAsStream("file location");
prop.load(in);
in.close();

//set property
prop.setProperty("key","value");

//store using output stream
prop.store(new FileOutputtream("File_Location");