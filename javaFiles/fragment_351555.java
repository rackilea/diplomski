public static void showResult(Mat img)
{   
    MatOfByte matOfByte = new MatOfByte();
    Imgcodecs.imencode(".jpg", img, matOfByte);
    byte[] byteArray = matOfByte.toArray();
    BufferedImage bufImage = null;
    try
    {
        InputStream in = new ByteArrayInputStream(byteArray);
        bufImage = ImageIO.read(in);
        JFrame frame = new JFrame();
        frame.getContentPane().add(new JLabel(new ImageIcon(bufImage)));
        frame.pack();
        frame.setVisible(true);
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
}