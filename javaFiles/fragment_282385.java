public class RedGreen implements Runnable {

    private JButton press;

    @Override
    public void run() {
        JFrame frame = new JFrame("RedGreen");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        press = new JButton("Press");
        press.addActionListener(new ActionListener() {
            boolean isGreen = false;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isGreen) {
                    press.setForeground(Color.RED);
                } else {
                    press.setForeground(Color.GREEN);
                }
                isGreen = !isGreen;
            }
        });
        frame.getContentPane().add(press);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String...args) throws Exception {
        SwingUtilities.invokeAndWait(new RedGreen());
    }
}