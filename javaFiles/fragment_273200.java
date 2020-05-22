Window.addWindowClosingHandler(new ClosingHandler() {
     @Override
      public void onWindowClosing(ClosingEvent event) {
      event.setMessage("My program");
      }
    });