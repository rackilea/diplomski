@UiHandler("tabPanel")
void handleSelect(SelectionEvent<Integer> e) {
    /* redraw only when switching to tab that contains visualization */
    if (e.getSelectedItem() == 1) {
        Scheduler.get().scheduleDeferred(new ScheduledCommand() {
            @Override
            public void execute() {
                drawVisualization();
            }
        });
    }
}