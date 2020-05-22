Window.addWindowScrollHandler(new Window.ScrollHandler() {
       public void onWindowScroll(Window.ScrollEvent event) {
         popupPanel.setPopupPosition(event.getScrollLeft()+fromLeft,
                                      event.getScrollTop()+fromTop);
       }
    });