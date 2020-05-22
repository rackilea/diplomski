TextArea area;
//... (initialize all your JavaFX objects here...)

// wherever you assign event handlers...
area.setOnKeyPressed(new EventHandler<KeyEvent>() {
    @Override
    public void handle(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER)  {
            String text = area.getText();

            // do your thing...

            // clear text
            area.setText("");
        }
    }
});