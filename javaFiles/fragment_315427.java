PDPage page = new PDPage();
    document.addPage(page);
    page.setRotation(90);
    PDPageContentStream contentStream = new PDPageContentStream(document, page);

    int x = 150;
    int y = 300;

    // draw unrotated
    contentStream.drawXObject(ximage, x, y, ximage.getWidth() / 2, ximage.getHeight() / 2);

    // draw 90° rotated, placed on the right of the first image
    AffineTransform at = new AffineTransform(ximage.getHeight() / 2, 0, 0, ximage.getWidth() / 2, x + ximage1.getWidth(), y);
    at.rotate(Math.toRadians(90));
    contentStream.drawXObject(ximage, at);