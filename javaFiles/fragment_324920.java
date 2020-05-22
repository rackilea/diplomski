public class StartupPlayer implements Player {

  public void play(){
    Controller controller = getController();
    controller.click(60, 278);
    controller.delay(0.5);
    controller.type("KevinBot");
    controller.delay(0.5);
    controller.click(400, 463);
  }

}