public GameOfLifeThing[] getThings() {
    GameOfLifeThing[] things = new GameOfLifeThing[mGoLQueue.size()];
    int i =0;
    while (!mGoLQueue.isEmpty()) {
        things[i++] = mGoLQueue.pop();
    }
    return things;
}