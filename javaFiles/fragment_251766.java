String fileName = config.getInitParameter("configFile");
System.out.println(fileName);
File file = new File(fileName);
FileInputStream fis = new FileInputStream(file);
p = new Properties();
p.load(fis);