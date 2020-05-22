ThreadLocal<Object> data = new ThreadLocal<Object>();

  public Object getData() {
      return this.data.get();
  }

  public void setData(Object data) {
      this.data.set(data);
  }