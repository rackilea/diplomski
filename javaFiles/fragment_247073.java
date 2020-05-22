try {
    URL imageResource = ChessFrame.class.getResource("/resources/icons/warning.png");
    if(imageResource != null) {
        warningImage = ImageIO.read(imageResource);
    } else {
        // do something useful
    }
} catch (IOException  e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Failed to load warning image,application will be shutdown");
    RunGame.getLogger().log(Level.WARNING, "Failed to load warning image, application was shutdown");
    System.exit(1);
}