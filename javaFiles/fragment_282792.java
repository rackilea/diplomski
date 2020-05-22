class Container {
  private List<?> data;

  public List<?> getData() {
    return this.data;
  }

  public void addData(Object data) {
    this.data.add(data);
  }
}