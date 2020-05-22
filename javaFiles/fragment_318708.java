public static void ShowImage(Mat img, String title, Integer...locs) {
    MatOfByte matOfByte = new MatOfByte();

    Highgui.imencode(".jpg", img, matOfByte);
    byte[] byteArray = matOfByte.toArray();
    BufferedImage bufImage = null;

    try {
        InputStream in = new ByteArrayInputStream(byteArray);
        bufImage = ImageIO.read(in);
        JFrame frame = new JFrame();
        frame.getContentPane().add(new JLabel(new ImageIcon(bufImage)));
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(title);

        if ((locs != null) && (locs.length > 0)) {
            frame.setLocation(locs[0], locs[1]);
        } else {
            frame.setLocation(START_X_LOC, START_Y_LOC);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}