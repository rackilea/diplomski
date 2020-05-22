try {
    for (int i = 0; i < h; i++) {
        for (int j = 0; j < h; j++) {
            int a = matrix3[i][j];
            Color newColor = new Color(a, a, a);
            image.setRGB(j, i, newColor.getRGB());
        }
    }
    ImageIO.write(image, "jpg", new File("Output.jpg"));
} catch (Exception e) {
    e.printStackTrace();
}