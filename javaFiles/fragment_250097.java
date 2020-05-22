public static final class Utils {

  public static Stage getStage() {
      return StageHelper.getStages().get(0);
  }

  public static void centre(Dialog dialog) {
      Window window = dialog.getWindow();
      Stage scene = Utils.getStage();
      double x = scene.getX() + scene.getWidth() / 2 - window.getWidth() / 2;
      double y = scene.getY() + scene.getHeight() / 2 - window.getHeight() / 2;
      window.setX(x);
      window.setY(y);
  }
}

...

Platform.runLater(() -> { Utils.centre(dialog); }
dialog.show();