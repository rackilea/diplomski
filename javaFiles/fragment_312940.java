public static void main(String[] args) {
    JFrame frame= new JFrame();
    frame.addKeyListener(new KeyAdapter() {

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println(e.getExtendedKeyCode());
        }            
    });
    frame.setBounds(0, 0, 100, 50);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}