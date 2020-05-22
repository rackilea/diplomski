Properties properties = new Properties();
properties.setProperty("foo", "cat1");
properties.setProperty("ba", "cat1");
properties.setProperty("fooz", "cat2");
properties.setProperty("baz", "cat2");
File storage = new File("index.properties");
// write to file
try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(storage), "UTF-8"))) {
    properties.store(writer, "index");
}

// Read from file
Properties readProps = new Properties();
try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(storage), "UTF-8"))) {
    readProps.load(reader);
}

if(!readProps.equals(properties)) {
    throw  new IllegalStateException("Written and read properties do not match");
}

System.out.println(readProps.getProperty("foo"));
System.out.println(readProps.getProperty("fooz"));