GRect[][] bricks = new GRect[nrows][bricksperrow];
for(j = 1; j <= nrows; j++) { 
    for(i = 0; i < bricksperrow; i++) {
        bricks[j - 1][i].setLocation(
                      i*(brickwidth + brickSep) + 1, 
                      brickoffset + j*(brickheight + brickSep));
        if(j == 1 || j == 2) {
            brick.setColor(Color.RED);
            brick.setFilled(true);
        }
        else if(j == 3 || j == 4) {
            brick.setColor(Color.ORANGE);
            brick.setFilled(true);
        }
        else if(j == 5 || j == 6) {
            brick.setColor(Color.YELLOW);
            brick.setFilled(true);
        }
        else if(j == 7 || j == 8) {
            brick.setColor(Color.GREEN);
            brick.setFilled(true);
        }
        else if(j == 9 || j == 10) {
            brick.setColor(Color.CYAN);
            brick.setFilled(true);
        }
        add(bricks[j - 1][i]);
    }
}