public static Image whiteOverlayStreak;
public static Image blackOverlayStreak;

DiagonalImages() {
    loadImages();
}

private void loadImages() {
    whiteOverlayStreak = new ImageIcon(
            getClass().getResource("/white.jpg")).getImage();
    blackOverlayStreak = new ImageIcon(
            getClass().getResource("/black.jpg")).getImage();
}

@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

        int x = r.nextInt(w);
        int y = r.nextInt(h);