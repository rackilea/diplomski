URL fxmlResource = getClass().getResource("/SomeComponent.fxml") ;
    InputStream inputStream = fxmlResource.openStream();
    byte[] buffer = new byte[8192];
    int totalBytes = 0 ;
    int bytesRead ;
    while((bytesRead = inputStream.read(buffer, totalBytes, buffer.length - totalBytes)) != -1) {
        totalBytes += bytesRead ;
        if (totalBytes == buffer.length) {
            byte[] newBuffer = new byte[2 * buffer.length];
            System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
            buffer = newBuffer ;
        }
    }

    inputStream.close();
    byte[] content = new byte[totalBytes];
    System.arraycopy(buffer, 0, content, 0, totalBytes);

    InputStream fxml = new ByteArrayInputStream(content);

    VBox vbox = new VBox(5);
    for(int i = 0; i < 8; i++) {
        FXMLLoader loader = new FXMLLoader();
        fxml.reset();
        vBox.getChildren().add(loader.load(fxml));
    }