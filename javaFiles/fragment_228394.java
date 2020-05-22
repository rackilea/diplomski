class ActionEventWrapper {
    private ActionEvent event;

    public MyActionEvent(ActionEvent event) {
        this.event = event;
    }

    //expose methods that aren't getSource()
    public String getActionCommand() {
        return event.getActionCommand();
    }
}