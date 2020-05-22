public static void main(String[] args) throws Exception {

    final URL lenna =
        new URL("http://upload.wikimedia.org/wikipedia/en/2/24/Lenna.png");

    final JSlider slider = new JSlider(0, 1000, 500);
    final ImageComponent image = new ImageComponent(lenna);
    slider.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            image.setZoom(2. * slider.getValue() / slider.getMaximum());
        }
    });

    JFrame frame = new JFrame("Test");
    frame.add(slider, BorderLayout.NORTH);

    frame.add(new JScrollPane(image));

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setVisible(true);
}