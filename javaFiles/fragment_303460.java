public class GwtTestApp implements EntryPoint {

  public void onModuleLoad() {
    MyMultiUploader uploader = new MyMultiUploader("file1.txt", "file2.doc");
    RootPanel.get().add(uploader);
  }

  public static class MyMultiUploader extends MultiUploader {

    private VerticalPanel panel;
    private Widget multiuploader;

    @Override
    protected void initWidget(Widget widget) {
      panel = new VerticalPanel();
      super.initWidget(panel);
      multiuploader = widget;
    }

    public MyMultiUploader(String ...files) {

      for (String f : files ) {
        Uploader u = (Uploader)getUploaderInstance();
        IFileInput i = u.getFileInput();
        IUploadStatus s = u.getStatusWidget();

        i.setVisible(false);
        s.setVisible(true);
        u.getForm().removeFromParent();

        u.setServletPath("whatever");
        s.setFileName(f);
        s.setStatus(Status.SUCCESS);

        final String name = f;
        s.addCancelHandler(new UploadCancelHandler() {
          public void onCancel() {
            Window.alert("Cancel " + name);
          }
        });

        panel.add(u);
      }

      panel.add(multiuploader);
    }

  }

}