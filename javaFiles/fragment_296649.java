Random rand = new Random();
int i=0;
while(i<mapSize){
    int distanceToNextTree = rand.nextInt(MAX_DISTANCE_BETWEEN_TREES-MIN_DISTANCE_BETWEEN_TREES)
        +MIN_DISTANCE_BETWEEN_TREES;

    i = i+distanceToNextTree;
    if(i< mapSize){
        putTree(i);
    }
}