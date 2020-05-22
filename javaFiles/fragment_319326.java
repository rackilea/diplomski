FileReader fr1 = null;
FileReader fr2 = null;
try {
    fr1 = new FileReader("D:/reference.xml");
    fr2 = new FileReader("D:/comparison.xml");
} catch (FileNotFoundException e) {
    e.printStackTrace();
}