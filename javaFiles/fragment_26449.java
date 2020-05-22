Icon ic1 = null;
try {
    ic1 = new ImageIcon(ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("images/1.png")));
} catch (IOException e) {
    e.printStackTrace();
}