navigator.addViewChangeListener(new ViewChangeListener() {
  @Override
  public boolean beforeViewChange(ViewChangeEvent event) {
    View newView = event.getNewView();
    String newViewName = event.getViewName();

    return canUserAccessView(newView, newViewName);  
  }

  @Override
  public void afterViewChange(ViewChangeEvent event) {
    //NO-OP
  }
});