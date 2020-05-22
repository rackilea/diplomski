Properties p = new Properties()

p.load(new FileInputStream(args[0]))

if (p.getProperty("quitonload").equals("true")) {
  System.out.println("quitonload is true");
  System.exit(1);
}
System.out.println("quitonload is false");