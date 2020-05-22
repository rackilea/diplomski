public static JButton style1Button(String title,final JComponent... components) {
    JButton button = new JButton(title);
    button.setPreferredSize(new Dimension(80, 30));
    button.setFont(standardFont);
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            currentFont = standardFont;
            for(JComponent c : components){
                c.setFont(currentFont);
            }
            frame.repaint();
        }
    });
    return button;
}