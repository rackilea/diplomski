class MyItemBuilder {
  private bool isCanceled = false;
  private MyItem item;
  // includes getters/setters of MyItem, which delegate to item

  public bool cancel() {
    isCanceled = true;
  }

  public MyItem build() {
    if (isCanceled) 
      return null;
    else
      return item;
  }
}

public class AddRecordDialog extends Dialog {
  private MyItemBuilder builder = new MyItemBuilder();
  ...
}