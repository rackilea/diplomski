for (int row = 1; row <= baseLength; row++) {
        currentX = startX;
        if (row % 2 == 0) {
            g.setColor(Color.blue);
        }
        else {
            g.setColor(Color.red);
        }
        System.out.println("row = " + row);


        for (int col = 0; col <= baseLength - row; col++) {
            System.out.println("col = " + col);
            g.fillRoundRect(currentX, currentY, legoWidth, legoHeight, arcWidth, arcHeight);
            currentX = currentX + legoWidth;
        }
        currentY -= legoHeight;
        startX += legoWidth / 2;
    }