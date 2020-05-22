import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.Widget;

public class WidgetGridCell extends AbstractCell<Widget> {

  Widget widget;

  public WidgetGridCell(Widget widget) {
      this.widget = widget;
  }

  @Override
  public void render(Context paramContext,
          Widget param, SafeHtmlBuilder pb) {
    Button aButton = new Button();
    // add text to the button, etc...
    pb.append(SafeHtmlUtils.fromTrustedString(aButton.toString()));
  }
}