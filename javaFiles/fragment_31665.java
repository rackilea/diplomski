class ShellActivationTracker implements Listener {
  Shell activeShell;

  ShellActivationTracker(Display display) {
    activeShell = display.getActiveShell();
    display.addFilter(SWT.Activate, this);
  }

  @Override
  public void handleEvent(Event event) {
    if (event.widget instanceof Shell) {
      activeShell = (Shell)event.widget;
    }
  }
}