primaryStage.setOnCloseRequest(new EventHandler() {
    public void handle(Event t) {
        t.consume();
        Action response = Dialogs.create()
                .owner(new Stage())
                .title("Exit ??")
                .masthead("Do you want to Exit ??")
                .actions(Dialog.Actions.OK, Dialog.Actions.CANCEL)
                .showConfirm();

        if (response == Dialog.Actions.OK) {
            primaryStage.close();
            System.exit(0);

        } else if (response == Dialog.Actions.CANCEL){

        }

    }
});