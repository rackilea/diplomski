private final ObjectProperty<BigDecimal> decGPA = new SimpleObjectProperty(BigDecimal.ZERO);

private void findGPA(){
    GPA = gradeCre/sum;
    decGPA.set(BigDecimal.valueOf(GPA).setScale(2, RoundingMode.CEILING));
    System.out.println("Your average GPA is: " + decGPA.get());
}

private Text createText(ObservableValue<String> textExpression){

    Text avgGPA = new Text();
    avgGPA.textProperty().bind(textExpression);
    avgGPA.setBoundsType(TextBoundsType.VISUAL);
    avgGPA.getStyleClass().add("avgGPA");

    return avgGPA;
}