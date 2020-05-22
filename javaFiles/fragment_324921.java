public interface Player {

  default void giveUp() {
    controller().
      click(new Rectangle(704, 545, 64, 18)).
      delay(0.1).
      click(new Rectangle(704, 545, 64, 18));
  }

  default void play() {
    giveUp();
  }

  default Controller controller() {
    return Controller.getInstance();
  }

}

public class StartupPlayer implements Player {

  public void play(){
    controller().
      click(60, 278).
      delay(0.5).
      type("KevinBot").
      delay(0.5).
      click(400, 463);
  }

}