System.setProperty("java.awt.headless", "true"); // assume it is enabled somewhere
File desktop = new File(System.getProperty("user.home"), "Desktop");
File text = new File(desktop, "a.txt");
setHeadless(false);
Desktop.getDesktop().open(text);
setHeadless(true);
Desktop.getDesktop().open(text);