String os = System.getProperty("os.name");
String jv = System.getProperty("java.version");
String userfolder = System.getProperty("user.home");

//Here you call the writeFile method the number of time that you need:
writeFile(userfolder + "opsys.txt", os);
....