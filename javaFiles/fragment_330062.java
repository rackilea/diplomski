... in the model class ...

  private void notifyListeners() {
    ModelChangeEvent event = new ModelChangeEvent(this);
    for (ModelListener listener : listeners) {
      listener.modelChanged(event);
    }
  }