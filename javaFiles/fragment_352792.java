private ControlPane cp;
private HangManPane hangManPane;

//...

public GamePane() {
    cp = new ControlPane();
    hangManPane = new HangManPane(null);

    cp.addChangeListener(new ChangeListener() {
        public void stateChanged(ChangeEvent evt) {
            String secret = cp.getSecretWord();
            DefaultHangManModel model = new DefaultHangManModel(secret);
            hangManPane.setModel(model);
        }
    });
}