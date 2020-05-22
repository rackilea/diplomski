@Override
protected void beforeFormB(Form f) {
    f.removeAllCommand();
    f.setBackCommand(null);
    Command back = new Command("Back") {

        @Override
        public void actionPerformed(ActionEvent evt) {
            Form backForm = (Form) createContainer("/theme", "Form A");
            backForm.showBack();
            beforeShow(backForm);
            postShow(backForm);

            //If your form was hand coded, do this instead
            new FormA().showBack();
        }
    };
    back.putClientProperty("uiid", "BackCommand");
    f.setBackCommand(back);
}