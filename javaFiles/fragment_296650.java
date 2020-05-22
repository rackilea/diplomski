Random rand = new Random();
int deltaX = MIN_WIDTH_BETWEEN_TREES;
int deltaY = MIN_HEIGHT_BETWEEN_TREES;
for(int x=0; x<MAP_WIDTH; x+=deltaX){
    for(int y=0; y<MAP_HEIGHT; y+=deltaY){
        boolean chunkHasTree = rand.nextBoolean();
        int chunkCenterX = x+deltaX/2;
        int chunkCenterY = y+deltaY/2;
        if(treeWithinRange(chunkCenterX,chunkCenterY,MAX_DISTANCE_BETWEEN_TREES)){
            //force a tree if there aren't any nearby
            chunkHasTree = true;
        }
        if(chunkHasTree && chunkCenterX<MAP_WIDTH && chunkCenterY<MAP_HEIGHT){
            placeTree(chunkCenterX,chunkCenterY);
        }
    }
}