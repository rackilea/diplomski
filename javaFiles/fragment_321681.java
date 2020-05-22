int boxWidth = 30;
    int boxHeight = 30;

    for (int currentX = 0; 
            currentX < playinggrid.length * boxWidth;
            currentX += boxWidth) {
        for (int currentY = 0;
                currentY < playinggrid[0].length * boxHeight;
                currentY += boxHeight) {
            g.drawRect(currentX, currentY, boxWidth, boxHeight);
        }
    }