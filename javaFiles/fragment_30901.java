FileInputStream propFile;
try {
    propFile = new FileInputStream(new File("dbinterface.properties"));
} catch (FileNotFoundException e) {
    propFile = new FileInputStream(new File("resources/dbinterface.properties"));
}
Properties p = new Properties();
p.load(propFile);
propFile.close();