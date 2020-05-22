private void destroyOneRandomBrick(){

    ArrayList<BaseActor> brickList = BaseActor.getList("Brick");
    int randomBrickIndex= MathUtils.random(brickList.size()-1);
    BaseActor randomBrick= brickList.get(randomBrickIndex);
    randomBrick.remove();   //Actor removed from stage
    s.remove(randomBrick);  //Item removed from ArrayList
    score+=100;
    scoreLabel.setText("Score: " + score);
}