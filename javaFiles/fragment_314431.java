interface CommonInterface<T extends CommonInterface<T>> {
  Collection<T> getObservableList();
}

public <T extends CommonInterface<T>> T findCarTableView(T t, Button button) {
  for(T carnet : t.getObservableList()) {
   ...
  }
}