iconPanel panel = new iconPanel("...");
... // then in some listener
public void actionPerformed(ActionEvent e) {
    Image pic = null;
    try {
        pic = ImageIO.read(...);
        panel.setPic(pic);
    } catch ...
}