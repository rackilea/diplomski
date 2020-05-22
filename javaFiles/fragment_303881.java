public class PaintEvent {
  public static final int OPER_DRAW_CIRCLE = 0;
  public static final int OPER_DRAW_RECT   = 1;
  public static final int OPER_DRAW_TEXT   = 2;
  ...etc...

  int paintOperationID;
  int[] paintDetails;           // where 'paintDetails' contains data such as a circle's radius, a rectangle's dimensions, the (x, y) location where to render text, etc.
  java.awt.Color renderColor;
  String text;

  public PaintEvent(int paintOperationID, int[] paintDetails, Color renderColor, String text) {
     ...
  }

}