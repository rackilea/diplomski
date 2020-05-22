OozieClient wc = new OozieClient("http://something:1100/oozie");

Properties conf = wc.createConfiguration();
Properties p = new Properties();
FileInputStream fis = new FileInputStream("myfile.properties");
p.load(fis);
conf.putAll(p);
fis.close(); // you still need to close the stream