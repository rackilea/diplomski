@Override
protected LoopItem newTabContainer(final int tabIndex) {
  LoopItem item = super.newTabContainer(tabIndex);
  item.add(new Link<Void>("closeLink") {
    @Override
    public void onClick() {
      getTabs().remove(tabIndex);
    }
  });
  return item;
}