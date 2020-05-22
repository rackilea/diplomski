private final Runnable saveCallback;

public WizardLayout(Runnable saveCallback) {
    this.saveCallback = saveCallback;
}

private void button_onClick(ClickEvent<Button> event) {
    ...
    saveCallback.run();
}