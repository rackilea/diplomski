File f = new File("profile.jpeg");
    BufferedImage image2 = ImageIO.read(f);
    RectangleAnnotation display = new RectangleAnnotation(image2);
    // Create a circle annotation.

    RectangleAnnotation ca = new RectangleAnnotation(20, 100, 60, 110);

    ca.setColor(Color.BLUE);
    ca.setStroke(dashed);
    // Add the annotation to the instance of DisplayJAIWithAnnotations.
    display.addAnnotation(ca);