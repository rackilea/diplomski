for (int i = 0; i < text.length; i++) {
    line = text[i].toCharArray();
    for (int j = 0; j < line.length; j++) {
        BufferedImage img = iLetters.get(Character.toString(line[j]));
        g2d.drawImage(img, drawX, drawY, null);
        if (j < line.length - 1) {
            drawX += letterWidth + 1;
        }
    }
    drawX = 0;
    if (i < text.length - 1) {
        drawY += letterHeight + 1;
    } else {
        drawY += letterHeight;
    }
}