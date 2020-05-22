@FXML
private WebView fontWebView ;

// ...

public void changeFont() {
    StringBuilder sb = new StringBuilder(fontText);
    for (int i = 0; i < fontSizes.length; i++) {
        sb.append("<p style='font-family:")
          .append(fontListView.getSelectionModel().getSelectedItem())
          .append(";font-size:")
          .append( fontSizes[i])
          .append("'>This is Sample Text</p>");
    }
    fontText = sb.toString();
    fontWebView.getEngine().loadContent(fontText);
}