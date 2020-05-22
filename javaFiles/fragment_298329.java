private void play(){
    ...
    PathTransition pathTransition = new PathTransition();
    ...
    pathTransition.setOnFinished(e->drawAfter());
    pathTransition.play();
}