class Container {
  private List<?> data;

  public synchronized List<?> getData() {
    return this.data;
  }

  public synchronized void addData(Object data) {
    this.data.add(data);
  }
}