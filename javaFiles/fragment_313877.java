...

  final static String MY_MIME_TYPE = "application/x-my-mime";
  public static final DataFormat FORMAT = new DataFormat(MY_MIME_TYPE);
  public static final DataFlavor FLAVOR = new DataFlavor(MY_MIME_TYPE, "My Mime Type");

  private void startDrag(Node node) {
    node.startDragAndDrop(TransferMode.COPY).setContent(
        Collections.singletonMap(FORMAT, "Test"));    
  }

  private boolean processData(TransferSupport support) {
    try (InputStream in = (InputStream) support.getTransferable().getTransferData(FLAVOR)) {
      Object transferred = new ObjectInputStream(in).readObject();
      System.out.println("transferred: " + transferred + " (" + transferred.getClass() + ")");
      return true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

...