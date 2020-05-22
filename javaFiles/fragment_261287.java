PlatformUI.getWorkbench().getDisplay().addFilter(SWT.MouseHover, new Listener() {

@Override
public void handleEvent(Event event) {
    // Check that this is the proper widget the action should be performed on
    event.widget.notifyListeners(SWT.MouseDown, new Event());
    event.widget.notifyListeners(SWT.MouseUp, new Event());
});