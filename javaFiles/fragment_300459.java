public class DomElement
{
  void insertChild(int pos, DomElement) {...}
  void setAttribute(String name, String value){...}
  String getAttribute(String name) {}
}
...
public class JQuery
{
  private final List<DomElement> els;
  public static JQuery $(DomElement ...e)
  {
     return new JQuery(Arrays.asList(e));
  }
  ...// some more methods which allow to create $-object with some other ways.

  private JQuery(List<DomElement> els)
  {
    this.els = els;
  }

  public String attr(String name)
  {
    return els.get(0).getAttribute(name);
  }
  public JQuery attr(String name, String value)
  {
    for(DomElement el : els)
      el.setAttribute(name, value);
    return this;
  }
...
}