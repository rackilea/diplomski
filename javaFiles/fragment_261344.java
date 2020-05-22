public class ViewController {

  private String savedStr;

  public void init() {
    for (Baloon baloon : baloons) {
        baloon.setOnMouseClicked(event -> {
            if (savedStr == null) { // Mouse Event 1
              savedStr = baloon.getString());
            } else { // Mouse Event 2
              checkTranslation(savedStr, baloon.getString());
              savedStr  = null;
            }
        }
    }
  }
}