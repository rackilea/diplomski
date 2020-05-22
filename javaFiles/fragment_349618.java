public class TimedIconChange {

    static String ICON_1_URL = "https://4.img-dpreview.com/files/p/E~TS590x0~articles/3925134721/0266554465.jpeg";
    static String ICON_2_URL = "https://www.sample-videos.com/img/Sample-png-image-500kb.png";
    static String ICON_3_URL = "http://www.frankieballard.com/sites/g/files/g2000005856/f/Sample-image10-highres.jpg";

    public static void main(String[] args) throws MalformedURLException {
        Icon icon1 = new ImageIcon(new URL(ICON_1_URL));
        Icon icon2 = new ImageIcon(new URL(ICON_2_URL));
        Icon icon3 = new ImageIcon(new URL(ICON_3_URL));
        List<Icon> circularIcons = new ArrayList<>() {
            int i = 0;
            @Override
            public Icon get(int index) {
                return get();
            }
            private Icon get() {
                if (i == size()) {
                    i = 0;
                }
                return super.get(i++);
            }
        };
        circularIcons.add(icon3);
        circularIcons.add(icon2);
        circularIcons.add(icon1);

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            JLabel label = new JLabel();
            label.setIcon(icon1);
            frame.setLayout(new BorderLayout());
            frame.add(label);
            frame.pack();
            frame.setVisible(true);
            new Timer(1000, e -> label.setIcon(circularIcons.get(0))).start();
        });
    }
}