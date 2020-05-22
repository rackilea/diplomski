public static void main(String[] args) {
    JFrame f = new JFrame();
    f.setSize(600, 400);
    f.getContentPane().setLayout(new BorderLayout());
    BufferedImage bi = new BufferedImage(200, 100, BufferedImage.TYPE_BYTE_GRAY);
    WritableRaster wr = bi.getRaster();
    for (int col=0; col<bi.getWidth(); col++) {
        for (int row=0; row<bi.getHeight(); row++) {
            wr.setPixel(col, row, new int[] {(col+row)&0xff});
        }
    }
    JLabel l = new JLabel(new ImageIcon(bi));
    f.getContentPane().add(l, BorderLayout.CENTER);
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.setVisible(true);
}