private void takeScreenshot(String print){
        JFileChooser c = new JFileChooser(getRealDesktop());
        FileFilter jpeg = new FileNameExtensionFilter("JPEG (*.jpg;*.jpeg;*.jpe;*.jfif)", "jpg", "jpeg", "jpe", "jfif");
        c.setFileFilter(jpeg);
        c.showSaveDialog(this);
        if(c.getSelectedFile() != null){
            ssLoc = c.getSelectedFile().getAbsolutePath()+".jpg";
            try {
                Thread.sleep(150);
                Robot robot = new Robot();
                BufferedImage screenShot = robot.createScreenCapture(new Rectangle(ssWindow.getX(),ssWindow.getY(),ssWindow.getWidth(),ssWindow.getHeight()));
                ImageIO.write(screenShot, "JPG", new File(ssLoc));
                System.out.println(print);
            } catch (AWTException | IOException | InterruptedException ex) {
                Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }