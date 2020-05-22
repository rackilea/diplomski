public abstract class ClickHandlerData<I> implements ClickHandler {
  private I data;

  public ClickHandlerData(I data) {
      this.data = data;
  }

  public I getData() {
      return data;
  }

  public void setData(I data) {
      this.data = data;
  }
}