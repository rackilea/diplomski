// on Linux
File f1 = new File("/testFolder/test.png");
File f2 = new File("/testFolder/test.PNG");
File f3 = new File("/testFolder/test.PnG");
f1.exists(); // false
f2.exists(); // false
f3.exists(); // true

// on Windows
File f1 = new File("c:\\testFolder\\test.png");
File f2 = new File("c:\\testFolder\\test.PNG");
File f3 = new File("c:\\testFolder\\test.PnG");
f1.exists(); // true
f2.exists(); // true
f3.exists(); // true