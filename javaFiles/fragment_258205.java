private void changeScenes()
{
    CusInfo ci = new CusInfo();
    Scene scene = ci.getScene();

    // set new title
    primaryStage.setTitle("Customer Information");

    // change the scene on the stage
    primaryStage.setScene(scene);
}