Hyperlink myLink = new Hyperlink("foo");
myLink.addClickHandler(new ClickHandler() {
  @Override
  public void onClick(ClickEvent event) {
    String currentToken = History.getToken();
    String newToken = ((Hyperlink) event.getSource()).getTargetHistoryToken();
    if (currentToken == newToken) {
      History.fireCurrentHistoryState();
    }
  }
});