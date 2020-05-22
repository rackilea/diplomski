public static void main(String[] args) throws MalformedURLException, IOException{
    final BufferedImage image = ImageIO.read(new URL(
                  "http://upload.wikimedia.org/wikipedia/en/2/24/Lenna.png"));

    JFrame frame = new JFrame("Test");

    frame.add(new JTable(18, 5) {{
            setOpaque(false);
            setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {{
                setOpaque(false);
            }});
        }
        @Override
        protected void paintComponent(Graphics g) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
            super.paintComponent(g);
        }
    });
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
}