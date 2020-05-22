private XYChart.Series<Number, Number> getSeries() {

    double xMax1 = Double.parseDouble(xMax.getText());
    double xMin1 = Double.parseDouble(xMin.getText());
    double a = Double.parseDouble(factorA.getText());
    double b = Double.parseDouble(factorB.getText());
    double c = Double.parseDouble(factorC.getText());

    XYChart.Series<Number,Number> series = new XYChart.Series<Number, Number>();
    series.setName("Chart");

    String pattern;
    if (a == 0 && c == 0) {
        pattern = "f(x)=" + factorB.getText();
        label.setText(pattern);
    } else if (c == 0) {
        pattern = "f(x)=" + factorA.getText() + "x+" + factorB.getText();
        label.setText(pattern);
        for (double i = xMin1; i <= xMax1; i++) {
            double y = a * i + b;
            series.getData().add(new Data<Number, Number>(i, y));
        }
    } else {
        pattern = "f(x)=" + factorA.getText() + "x^2+" + factorB.getText() + "x+" + factorC.getText();
        label.setText(pattern);
        for (double i = xMin1; i < xMax1; i++) {
            double y = a * i * i + b * i + c;
            series.getData().add(new Data<Number, Number>(i, y));
        }
    }

    return series;
}