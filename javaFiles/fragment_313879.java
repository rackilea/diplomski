...

  private void startDrag(Node node) {
    node.startDragAndDrop(TransferMode.COPY).setContent(
        // put a ByteBuffer to transfer the content unaffected
        Collections.singletonMap(FORMAT, StandardCharsets.UTF_8.encode("Test")));
  }

  private boolean processData(TransferSupport support) {
    try (InputStream in = (InputStream) support.getTransferable().getTransferData(FLAVOR)) {
      byte[] textBytes = new byte[in.available()];
      in.read(textBytes);
      String transferred = new String(textBytes, StandardCharsets.UTF_8); 
      System.out.println("transferred text: " + transferred);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }  

...