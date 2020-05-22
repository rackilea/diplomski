@Test
public void testOne() throws IOException {

    File file = new File(getClass().getClassLoader().getResource("image_to_click.jpeg").getFile());
    browse(new URL("http://code.google.com"));

    // click image that looks like image_to_click.jpeg
    ScreenRegion s = new DesktopScreenRegion(1);
    ScreenRegion s1 = s.find(new ImageTarget(file));
    Mouse mouse = new DesktopMouse();
    mouse.click(s1.getCenter());

    // take a screenshot and save it
    BufferedImage img = s.capture();
    File outputfile = new File("screenshot_image.jpg");
    ImageIO.write(img, "jpg", outputfile);
}