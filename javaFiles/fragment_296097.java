final IntegerProperty count = new SimpleIntegerProperty(0);
Text text = new Text("-");
// Bind count to text, to show on scene.
text.textProperty().bind(count.asString());

ChangeListener listener = new ChangeListener<Boolean>() {
    @Override
    public void changed(final ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        count.set(count.get() + (newValue ? 1 : -1));
        if (count.get() >= 10) {
            System.out.println("exceeded max limit");
            // Revert selection
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    ((BooleanProperty) observable).set(false);
                }
            });
        }
    }
};
for (final Card card : cards.getItems()) {
    card.selectedProperty().addListener(listener);
}