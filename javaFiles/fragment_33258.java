//Draws the image to the ClockFace panel
public void paintComponent(Graphics g) {

    Graphics2D twoD = (Graphics2D) g;
    twoD.drawImage(clockFace, 0, 0, null);

}