JEditorPane jep = new JEditorPane("text/html", "Click <a href='pdf'>here</a> to display a PDF file. For more information click <a href='info'>here</a>.");
jep.setEditable(false);
jep.setOpaque(false);
jep.addHyperlinkListener(new HyperlinkListener() {
  public void hyperlinkUpdate(HyperlinkEvent hle) {
    if (HyperlinkEvent.EventType.ACTIVATED.equals(hle.getEventType())) {
      if (hle.getDescription().equalsIgnoreCase("pdf")) {
        // display PDF
      } else if (hle.getDescription().equalsIgnoreCase("info")) {
        // display information
      }
    }
  }
});