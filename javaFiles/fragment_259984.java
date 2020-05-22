public void showAnotherStage(){
    //(Create and setup the new stage and scene)

    new WindowModality(primaryStage, newStage);
    newStage.show();

    //Do something else.
}