public interface Player {

  default void giveUp() {
    Controller controller = getController();
    controller.click(new Rectangle(704, 545, 64, 18));
    controller.delay(0.1);
    controller.click(new Rectangle(704, 545, 64, 18));
  }

  default void play() {
    giveUp();
  }

  default Controller getController() {
    return Controller.getInstance();
  }

}