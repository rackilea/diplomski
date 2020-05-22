public class SpacerControl
{
  @PostConstruct
  public void postConstruct(Composite parent)
  {
    Composite body = new Composite(parent, SWT.NONE);

    body.setLayout(new GridLayout());
  }
}