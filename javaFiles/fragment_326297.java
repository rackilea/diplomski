tableColumn1.setCellValueFactory(t -> {
    MyModel myModelValue = t.getValue();
    return Bindings.when(myModelValue.property3().equals("something"))
        .then(myModelValue.property1())
        .otherwise(myModelValue.property2());
});