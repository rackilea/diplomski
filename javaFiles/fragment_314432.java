interface CommonInterface<T> {
  Collection<T> getObservableList();
}

public <T> T findCarTableView(CommonInterface<T> t, Button button) {
  for(T carnet : t.getObservableList()) {
   ...
  }
}