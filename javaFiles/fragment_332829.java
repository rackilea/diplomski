public class TestRgb {
  @Test
  public void testBlack(){
    BufferedImage bufferedImage = new BufferedImage(1,1, TYPE_BYTE_BINARY);
    Graphics2D graphics2D = bufferedImage.createGraphics();
    graphics2D.setPaint(new Color(0,0,0)); //black
    graphics2D.fillRect(0,0,1,1);

    // pass - alpha channel set by default, even on all black pixels
    TestCase.assertTrue(bufferedImage.getRGB(0,0)==0xFF000000);

    // pass - when looking at just the color values (last 24 bits) the value is 0
    TestCase.assertTrue((bufferedImage.getRGB(0,0) & 0x00FFFFFF)==0);

    // fail - see above
    TestCase.assertTrue(bufferedImage.getRGB(0,0)==0);
  }
}