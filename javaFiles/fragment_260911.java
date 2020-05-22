engine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {

    @Override
    public void changed(ObservableValue<? extends State> observable, State oldValue, final State newValue) {
        if (newValue == FAILED) {
            final int result = JOptionPane.showConfirmDialog(
                panel,
                MessagesBundle.getString("error_message_unable_connect_to_internet"),
                MessagesBundle.getString("error_title_unable_connect_to_internet"),
                JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {
                if (loadedURL != null) {
                    engine.load(loadedURL);
                }
            }
        }
    }
});