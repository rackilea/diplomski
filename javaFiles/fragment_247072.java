try {
    warningImage = ImageIO.read(ChessFrame.class.getResource("/resources/icons/warning.png"));
} catch (IOException | NullPointerException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Failed to load warning image,application will be shutdown");
    RunGame.getLogger().log(Level.WARNING, "Failed to load warning image, application was shutdown");
    System.exit(1);
}