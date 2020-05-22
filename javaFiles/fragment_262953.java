Random rnd = new Random();
int[][] pixels = new int[128][128];
for (int y = 0; y < 128; y++) {
    for (int x = 0; x < 128; x++) {
        pixels[y][x] = rnd.nextInt(255);
    }
}

BufferedImage img = new BufferedImage(128, 128, BufferedImage.TYPE_INT_RGB);
for (int y = 0; y < 128; y++) {
    for (int x = 0; x < 128; x++) {
        Color color = new Color(pixels[y][x], pixels[y][x], pixels[y][x]);
        img.setRGB(x, y, color.getRGB());
    }
}
JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img)));
try {
    ImageIO.write(img, "png",  new File("SuperDuppa.png"));
} catch (IOException ex) {
    ex.printStackTrace();
}