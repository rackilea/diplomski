public GraphicsMovement2() {
    try {
        File file = new File("C:\\Users/Jonheel/Google Drive/School/10th Grade/AP Computer Science/Junkbin/MegaLogo.png");
        ImageInputStream imgInpt = new FileImageInputStream(file);
        image = ImageIO.read(file);
    }
    catch(FileNotFoundException e) {
        System.out.println("x");
    }
    catch(IOException e) {
        System.out.println("y");
    }
}