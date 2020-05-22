for (Image anImage : image) {
    if ((x + offset + width) >= -RENDER_MARGIN && x + offset <= (canvasWidth + RENDER_MARGIN)) { 
        gc.drawImage(anImage, x + offset, y, width, height);
        drawn++;
    } else {
        segmentsSkipped++;
    }
    offset += width;
}