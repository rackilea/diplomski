@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    System.out.println("image is null: " + (image == null)); // TODO: Delete this
    g.drawImage(image, getWidth(), getHeight(), null);      
}