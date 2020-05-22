@Override
protected void populateItem(ListItem<String> _item)
{
  final String s = _item.getModelObject();
  AjaxLink link = new AjaxLink("link")
  {
    @Override
    public void onClick(AjaxRequestTarget target)
    {
      doSomethingWithString(s);
    }
  };
  _item.add(link);
  link.add(new Label("label", s));
}