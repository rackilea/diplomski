<%

FileInputStream fis = new FileInputStream("/etc/path/some.properties");
Properties prop = new Properties();


try {
   prop.load(fis);
} 
catch (IOException e) {
    e.printStackTrace();
}

String someId = prop.getProperty("some.demo.id");
%>