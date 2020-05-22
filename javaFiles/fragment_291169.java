java.net.URL resFileURL = MyTest.class.getResource("/com/abc/pkg/test/resources/testdata.xml");
File resFile = new File(fileURL);        
OR 
InputStream resFileIS = 
     MyTest.class.getResourceAsStream("/com/abc/pkg/test/resources/testdata.xml");   
OR 
java.net.URL resFileURL = MyTest.class.getClassLoader().getResource("com/abc/pkg/test/resources/testdata.xml");
File resFile = new File(fileURL);       
OR 
InputStream resFileIS = 
     MyTest.class.getClassLoader().getResourceAsStream("com/abc/pkg/test/resources/testdata.xml");