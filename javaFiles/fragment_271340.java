public class CopyableLabel extends Label {

  public CopyableLabel(CopyableLabel label) {
    // You only mentioned the text, tooltip, and style properties
    // in your question. Bind more properties as needed.
    textProperty().bind(label.textProperty());
    tooltipProperty().bind(label.tooltipProperty());
    styleProperty().bind(label.styleProperty());
  }

}