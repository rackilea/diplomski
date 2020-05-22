public static void main(String args[]) {
    JFrame frame = new JFrame();
    frame.setSize(200, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel(new GridLayout(2, 1));
    final JLabel iconLabel = new JLabel();
    JButton button = new JButton("Put Image");
    button.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent arg0) {
            JFileChooser fc = new JFileChooser();
            int returnVal = fc.showOpenDialog(null);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    iconLabel.setIcon(new ImageIcon(ImageIO.read(fc.getSelectedFile())));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    });
    panel.add(iconLabel);
    panel.add(button);
    frame.add(panel);
    frame.setVisible(true);
}