final int width=500, height=500;
final String title = "Example";
JFrame frame = new JFrame(title);
frame.setBackground(Color.WHITE);
frame.setSize(width, height);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setResizable(false);
frame.setLocationRelativeTo(null);
frame.setUndecorated(true);

JLabel popup = new JLabel("Popup") {
    // enforce filling of (transparent) background while opaque:=false
    @Override protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
    @Override public boolean isOpaque() {
        return false;
    }
};
popup.setBackground(new Color(0x77996622, true));
popup.setForeground(Color.WHITE);
popup.setFont(popup.getFont().deriveFont(30f));
popup.setHorizontalAlignment(JLabel.CENTER);
popup.setVerticalAlignment(JLabel.TOP);
popup.setBounds(100, 100, width-200, height-200);

JLabel content = new JLabel("Actual Content");
content.setForeground(Color.BLACK);
content.setFont(content.getFont().deriveFont(50f));
content.setHorizontalAlignment(JLabel.CENTER);
frame.getContentPane().add(content, BorderLayout.CENTER);
frame.getContentPane().setBackground(Color.WHITE);
frame.getLayeredPane().add(popup, JLayeredPane.POPUP_LAYER);
frame.setVisible(true);
new Timer(2000, ev->popup.setVisible(!popup.isVisible())).start();