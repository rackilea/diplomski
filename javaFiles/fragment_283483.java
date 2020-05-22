public class SliderSample {
    private JSlider js4 = new JSlider(1, 5);
    private int state = js4.getValue();

    public static void main(final String args[]) {
         SwingUtilities.invokeLater(new Runnable() {
              @Override
              public void run() {
                  new SliderSample();
              }
         });
    }

    public SliderSample() {
        JFrame frame = new JFrame("Sample Sliders");
        ...

        JButton b = new JButton("Save");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state = js4.getValue();
                System.out.println("new state: " + state);
            }
        });

        Hashtable<Integer, JComponent> table = new Hashtable<Integer, JComponent>();
        ...
        frame.setVisible(true);
}