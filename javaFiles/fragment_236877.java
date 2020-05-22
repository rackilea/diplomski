public class SampleEntryPoint implements EntryPoint {
  public void onModuleLoad() {
    Label label = new Label("Hello, World!");
    label.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        GWT.runAsync(new RunAsyncCallback() {
          public void onFailure(Throwable var1) {/*ignore*/}
          public void onSuccess() {
            Window.alert("Clicked, and loaded in split point!");
          }
        });
      }
    });
    RootPanel.get().add(label);
  }
}