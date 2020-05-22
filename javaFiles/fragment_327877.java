Event event = new Event();
event.type = SWT.DragDetect;
event.display = getDisplay();
event.widget = this;
event.button = e.button;
event.stateMask = e.stateMask;
event.time = e.time;
event.x = e.x;
event.y = e.y;

notifyListeners(SWT.DragDetect, event);