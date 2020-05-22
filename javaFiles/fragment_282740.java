@Override
protected void init(VaadinRequest request) {

  VerticalLayout layout = new VerticalLayout();
  setContent(layout);
  // Add this
  layout.setHeight("100%");

  // The rest is the same
  ...