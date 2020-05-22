webview.addEventFilter(ScrollEvent.SCROLL, (ScrollEvent e) -> {
     double deltaY = e.getDeltaY();
     if(e.isControlDown() && deltaY > 0) {
        webview.setZoom(webview.getZoom() * 1.1);
        e.consume();
     } else if(e.isControlDown() && deltaY < 0) {
        webview.setZoom(webview.getZoom() / 1.1);
        e.consume();
     }
  });