Task<Void> loadTask = new Task<Void>() {
    @Override
    protected Void call() throws Exception {
        for (int i = 0; i <= 200; i++) {
            Thread.sleep(40);
            String text = "";
            if (i <= 30)
                text = "Initilizing Components...";
            else if (i <= 50)
                text = "Initializing Database Connection...";
            else if (i <= 80)
                text = "Initializing User Interface...";
            else
                text = "Please wait...";

            String finalText = text;
            Platform.runLater(() -> lblLoad.setText(finalText));
        }
        return null;
    }
};


new Thread(loadTask).start();