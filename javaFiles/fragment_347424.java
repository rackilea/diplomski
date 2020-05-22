String db = "jdbc:sqlserver://dummydata\\SHARED";
System.out.println(db); // To see actual string value

Properties properties = new Properties();
properties.setProperty("db", db);
try (FileWriter out = new FileWriter("test.properties")) {
    properties.store(out, null);
}