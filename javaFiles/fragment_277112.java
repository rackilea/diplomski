package styles;

import javafx.scene.paint.Color;

public final class Theme {

  /** Constant field; use Theme.BASE_COLOR */
  public static final Color BASE_COLOR = Color.TEAL;

  /** Getter method for FXML; use ${theme.baseColor} */
  public Color getBaseColor() { return BASE_COLOR; }
}