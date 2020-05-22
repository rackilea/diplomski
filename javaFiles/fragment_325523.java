public void onFormActionEvent(com.codename1.ui.events.ActionEvent ev) {
    Form formB = new FormB();
    formB.getToolbar().setBackCommand(back);
    formB.setBackCommand(back);
    formB.show();
}