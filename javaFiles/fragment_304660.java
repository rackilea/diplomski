public class MainFrame extends JFrame {
    public MainFrame() {
        setMinimumSize(new Dimension(200, 100));

        JButton myButton = new JButton("Initial");
        add(myButton);

        myButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                final JButton triggerBtn = (JButton) e.getSource();
                final String originalValue = triggerBtn.getText();
                triggerBtn.setText("New");

                JOptionPane.showMessageDialog(null, "Speak softly and carry a big stick and you will go far.");

                triggerBtn.setText(originalValue);
            }
        });
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
            }
        });
    }
}