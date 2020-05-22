public static void display(String path, JPanel panel){
    ...
    panel.removeAll();                          // Remove already added image
    panel.add(new JLabel(new ImageIcon(dimg))); // Add new image
    panel.revalidate();
    panel.repaint();
 }