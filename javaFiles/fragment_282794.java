class Container {
  private List<?> data;

  public List<?> getData() {
    synchronized (this.data) {
      return this.data;
    }
  }

  public void addData(Object data) {
    synchronized (this.data) {
      this.data.add(data);
    }
  }
}