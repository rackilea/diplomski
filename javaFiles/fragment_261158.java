public final void onWindowClosing(Window.ClosingEvent event) {
    event.setMessage(onLeaveQuestion);
    DeferredCommand.addCommand( new Command() {
      public void execute() {
        Window.Location.replace(currentLocation);
      }
    });
  }