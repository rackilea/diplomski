public class LoadingComposite extends Composite
{
  private SimplePanel content;

  public LoadingIndicatorComposite()
  {
    content = new SimplePanel();
    content.setWidget(new Label("Loading...") /* or a loading indicator image */);
    initWidget(content);
  }

  public void setContent(Widget w)
  {
    content.setWidget(w);
  }
}