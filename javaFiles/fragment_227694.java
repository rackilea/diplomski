for (int k = 0; k < coords[0]; k++) {
    for (int l = 0; l < coords[1]; l++) {
        //...
        BufferedImage img = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
        image.add(img);
        myColor = new Color(red,green,blue,255);
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                image.get(z).setRGB(i, j, myColor.getRGB());  
            }
        }
        myPanel = new MyPanel(img);
        panelDown.add(myPanel);
        z++;
    }
}