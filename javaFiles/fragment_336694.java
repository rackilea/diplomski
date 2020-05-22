offsetStage.show();

MeasureController ofX = loader.getController();
ofX.retdxProperty().addListener((o, oldValue, newValue) -> {
    // do something on value change
    System.out.println(newValue);
});