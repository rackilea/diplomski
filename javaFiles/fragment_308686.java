try {
    final ImageIcon icon = new ImageIcon(ImageIO.read(new File("paypalicon.gif")));

    JOptionPane.showOptionDialog(
            null,
            "Congratulations, you clicked the button.",
            "Congrats",
            JOptionPane.OK_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            icon,
            new Object[]{"Okay"},
            "Okay");
} catch (IOException exp) {
    exp.printStackTrace();
}