public void drawText(String line, float x, int y) {
    int len = line.length();
    batcher.beginBatch(Assets.numbers);
    for (int i = 0; i < len; i++) {
        char character = line.charAt(i);

        if (character == ' ') {
            x += 20;
            continue;
        }

        int srcX = 0;
        int srcWidth = 0;
        if (character == '.') {
            srcX = 200;
            srcWidth = 10;
        } else {
            srcX = (character - '0') * 20;
            srcWidth = 20;
        }


        if(character=='0')
            batcher.drawSprite(x, y, srcWidth, 32, Assets.zeroRegion);
        if(character=='1')
            batcher.drawSprite(x, y, srcWidth, 32, Assets.oneRegion);
     if(character=='2')
            batcher.drawSprite(x, y, srcWidth, 32, Assets.twoRegion);
         if(character=='3')
            batcher.drawSprite(x, y, srcWidth, 32, Assets.threeRegion);
         if(character=='4')
            batcher.drawSprite(x, y, srcWidth, 32, Assets.fourRegion);
         if(character=='5')
            batcher.drawSprite(x, y, srcWidth, 32, Assets.fiveRegion);
         if(character=='6')
            batcher.drawSprite(x, y, srcWidth, 32, Assets.sixRegion);
         if(character=='7')
            batcher.drawSprite(x, y, srcWidth, 32, Assets.sevenRegion);
         if(character=='8')
            batcher.drawSprite(x, y, srcWidth, 32, Assets.eightRegion);
         if(character=='9')
            batcher.drawSprite(x, y, srcWidth, 32, Assets.nineRegion);
         if(character=='.')
            batcher.drawSprite(x, y, srcWidth, 32, Assets.dotRegion);

        x += srcWidth;
    }
    batcher.endBatch();
}