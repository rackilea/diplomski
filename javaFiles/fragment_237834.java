File f = new File ("./phantomjs.exe");
if (!f.exists()) {
  InputStream in = Myclass.class.getClassLoader().getResourceAsStream("phantomjs.exe");
  OutputStream out = new FileOutputStream("./phantomjs.exe");
  IOUtils.copy(in, out);
}
System.setProperty("phantomjs.binary.path","./phantomjs.exe");