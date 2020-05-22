ArrayList<Rectangle> rects = WorldGenerator.BlockArray;

canGoLeft = true;
canGoRight = true;
for(int i = 0; i < rects.size(); i++) {
    // LEFT
    if(!(player.x >= rects.get(i).getX() + rects.get(i).getWidth() && player.y >= rects.get(i).getY() + rects.get(i).getHeight())) {
        canGoLeft = false;
    }

    // RIGHT
    if(!(player.x <= rects.get(i).getX() && player.y >= rects.get(i).getY() + rects.get(i).getHeight())) {
        canGoRight = false;
    }
}