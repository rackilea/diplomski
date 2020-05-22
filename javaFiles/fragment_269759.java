Event event = new Event();

event.widget = combo;
event.type = SWT.Selection;

combo.getDisplay().post(event);