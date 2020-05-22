EditorCookie.Observable cookie = dataObject.getLookup().lookup(EditorCookie.Observable.class);
cookie.addPropertyChangeListener(new PropertyChangeListener() {
  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    // Do your stuff
  }
});