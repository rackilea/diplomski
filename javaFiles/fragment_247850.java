public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            // your JSlider example class **that extends JPanel**
            SliderPanel sliderPanel = new SliderPanel();

            // your JButton example class **that extends JPanel**
            ButtonPanel buttonPanel = new ButtonPanel():

            JFrame frame = new JFrame("My GUI");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(sliderPanel, BorderLayout.PAGE_START);
            frame.add(buttonPanel, BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null); // center GUI if you want
            frame.setVisible(true);
        }

    });
}