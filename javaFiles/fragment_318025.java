// update text field:
double value = ... ;
textFormatter.setValue(value);

// listen for changes in double value represented in text field
// Listener will be invoked when the user commits an edit:

textFormatter.valueProperty().addListener((ObservableValue<? extends Double> obs, Double oldValue, Double newValue) -> {
    System.out.println("User entered value: "+newValue.doubleValue());
});