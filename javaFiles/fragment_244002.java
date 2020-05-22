main.addValueChangeListener((HasValue.ValueChangeListener<String>) valueChangeEvent -> {
    if (valueChangeEvent.getValue() != null) {
        dependent.setValue(null);
        dependent.setItems(dependentsByMain.get(valueChangeEvent.getValue())); 
    }
});