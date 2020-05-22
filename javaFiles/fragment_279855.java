private void takeSnapShot(){
    try {
        Robot robot = new Robot();
        Rectangle area = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage bufferedImage = robot.createScreenCapture(area);
        //Try to save the captured image
        try {
            File file = File.createTempFile(Long.toString(System.currentTimeMillis()), ".png");
            ImageIO.write(bufferedImage, "png", file);
            //send image
            file.delete();
        } catch (IOException ex) {
            Logger.getLogger(ScrCaptFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    } catch (AWTException ex) {
        Logger.getLogger(ScrCaptFrm.class.getName()).log(Level.SEVERE, null, ex);
    }
}