public class JavaLabels extends JFrame {

    private JLabel[] jLabelArr;
    private JPanel jLabelPanel = new JPanel();

    public JavaLabels() {
        setLayout(new FlowLayout());
        jLabelArr = new JLabel[10];
        for (int i = 0; i < 10; i++) {

            jLabelArr[i] = new JLabel(new ImageIcon("resources/image"));
            jLabelPanel.add(jLabelArr[i]);

            jLabelArr[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    onMouseClicked(e);
                }
            });
        }
        add(jLabelPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setSize(400, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void onMouseClicked(MouseEvent e) {
        for (int i = 0; i < 10; i++)
            if (e.getSource() == jLabelArr[i]) {
                System.out.println("Label" + i + "was clicked");
            }
    }

    public static void main(String[] args) {
        new JavaLabels();
    }
}