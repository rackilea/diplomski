// Assuming that your image will be within your package
final URL resource = getClass().getResource("/com/mypackage/myimage.png");

final JButton btn = new JButton("My Button");
final Image image = ImageIO.read(resource);
final ImageIcon defaultIcon = new ImageIcon(image);

btn.setIcon(defaultIcon);
btn.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent e) {
        try {
            //This will do the trick to brighten your image
            Graphics2D g2 = (Graphics2D) image.getGraphics();

            // Here we're creating a white color with 50% of alpha transparency
            g2.setColor(new Color(255, 255, 255, 50));
            // Fill the entire image with the new color
            g2.fillRect(0, 0, defaultIcon.getIconWidth(), defaultIcon.getIconHeight());
            g2.dispose();
            btnBtn.setIcon(new ImageIcon(image));
        } catch (Exception ex) {
            /*Although this is a bad practice, my point here is not 
             * to explain exceptions. 
             * But it's a good practice to always capture as many exceptions as you can
            */
        }
    }
});