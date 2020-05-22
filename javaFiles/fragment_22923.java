public class SimpleGuiC implements ActionListener {
    private JFrame frame;
    private MyDrawPanel drawPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleGuiC gui = new SimpleGuiC();
            gui.go();
        });
    }

    public void go() {
        frame = new JFrame();
        frame.setTitle("Gradient changer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Change colors");
        button.addActionListener(this);
        this.drawPanel = new MyDrawPanel();
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.drawPanel.changeColors();
    }
}