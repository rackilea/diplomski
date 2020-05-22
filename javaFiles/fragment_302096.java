Event event = new Event();
event.widget = penaltyPercent;
event.display = penaltyPercent.getDisplay();
event.type = SWT.Selection;

penaltyPercent.notifyListeners(SWT.Selection, event);