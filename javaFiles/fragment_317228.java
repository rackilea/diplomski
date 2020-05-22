public static void main(String[] args) {
    SwingUtilities.invokeLater(()->{
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        JLabel label = new JLabel("One");
        JButton button = new JButton("Ok");
        button.addActionListener(e -> {
            String oldText = label.getText();
            label.setText("Changed");
            Timer timer = new Timer(2000, event -> {
                label.setText(oldText);
            });
            timer.setRepeats(false);
            timer.start();
        });
        frame.add(label);
        frame.add(button);
        frame.pack();
        frame.setVisible(true);
    });
}