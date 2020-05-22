ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "StartSample.bat");
builder.directory(new File(PATH));
Process process = builder.start();
process.waitFor();

Properties p = new Properties();
try (FileInputStream fis = new FileInputStream("C:/PV/PVInfo.ini")) {
    p.load(fis);
}
String pvidNO1 = p.getProperty("PVIDNO");
String pvidNo2 = p.getProperty("PVIDNo");
String pvidNo3 = p.getProperty("PV-ID");