//...

@FXML
private TextArea txtLog;

// ...

public void checkUrl() {
    final String url = UrlInput.getText();
    final LogWriter lw = new LogWriter(txtLog);

    Task<String> task = new Task<String>() {

        @Override
        protected String call() {
            lw.printMsg("loading website sourcecode...");
            return HTMLParser.directUrlToCode(url);
        }

        @Override
        protected void succeeded() {
            super.succeeded();
            lw.printMsg(getValue());
        }

        @Override
        protected void failed() {
            super.failed();
            if (getException() != null) {
                getException().printStackTrace();
            }
            lw.printMsg("failed!");
        }
    };

    new Thread(task).start();
}