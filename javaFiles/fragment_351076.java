addDropHandler(new DropHandler() {

    @Override
    public void onDrop(DropEvent event) {
        if(!event.getDataTransfer().getData("text/plain").isEmpty()) {
            Scheduler.get().scheduleDeferred(new ScheduledCommand() {

                @Override
                public void execute() {
                    fireEvent(new TextChangeEvent(ExtendedTextBox.this.getText()));
                }
            });
        }

    }
});