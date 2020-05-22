public class MW extends JFrame {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI();
            }
        });
    }

    private static void createAndShowUI() {
        MW x = new MW();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 2));

        JPanel leftPanel = new JPanel();
        JLabel srcLabel = new JLabel("Source record:");
        leftPanel.add(srcLabel);
        JPanel rightPanel = new JPanel();
        JLabel dstLabel = new JLabel("Destination record:");
        rightPanel.add(dstLabel);

        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton okButton = new JButton("OK");
        buttonPanel.add(okButton);
        JButton cancelButton = new JButton("Cancel");
        buttonPanel.add(cancelButton);

        x.setSize(400, 400);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.add(mainPanel, BorderLayout.CENTER);
        x.add(buttonPanel, BorderLayout.PAGE_END);
        x.setLocationRelativeTo(null);
        x.setVisible(true);
    }
}