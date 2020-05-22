public class TestPrint implements Printable  {

    private BufferedImage background;
    public static final float DPI = 72;

    public static void main(String[] args) {
        new TestPrint();
    }

    public TestPrint() {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                try {
                    background = ImageIO.read(new File("C:/Users/shane/Dropbox/MegaTokyo/MgkGrl_Yuki_by_fredrin.jpg"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                float width = cmToPixel(21f, DPI);
                float height = cmToPixel(29.7f, DPI);

                Paper paper = new Paper();
                float margin = cmToPixel(1, DPI);
                paper.setImageableArea(margin, margin, width - (margin * 2), height - (margin * 2));
                PageFormat pf = new PageFormat();
                pf.setPaper(paper);

                BufferedImage img = new BufferedImage(Math.round(width), Math.round(height), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = img.createGraphics();
                g2d.setColor(Color.WHITE);
                g2d.fill(new Rectangle2D.Float(0, 0, width, height));
                try {
                    g2d.setClip(new Rectangle2D.Double(pf.getImageableX(), pf.getImageableY(), pf.getImageableWidth(), pf.getImageableHeight()));
                    print(g2d, pf, 0);
                } catch (PrinterException ex) {
                    ex.printStackTrace();
                }
                g2d.dispose();

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JLabel(new ImageIcon(img)));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });

    }

    public float cmToPixel(float cm, float dpi) {

        return (dpi / 2.54f) * cm;

    }

    public int print(Graphics graphics, PageFormat pageFormat, int page) throws PrinterException {

        if (page > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g = (Graphics2D) graphics;

        g.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        if (background != null) {

            int x = (int)Math.round((pageFormat.getImageableWidth() - background.getWidth()) / 2f);
            int y = (int)Math.round((pageFormat.getImageableHeight() - background.getHeight()) / 2f);

            g.drawImage(background, x, y, null);

        }

        g.setColor(Color.BLACK);
        g.draw(new Rectangle2D.Double(0, 0, pageFormat.getImageableWidth() - 1, pageFormat.getImageableHeight() - 1));

        return PAGE_EXISTS;
    }
}