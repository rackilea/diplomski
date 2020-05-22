if (currentCartTxt.getItems().size() > 0) {
    // get current value
    String text = numberOfSalesTxt.getText();

    // convert it from "String" to "int"
    int sales = Integer.parseInt(text);

    // increment it
    sales++;

    // Convert from "int" to "String"
    String x = Integer.toString(sales);

    // Set new value
    numberOfSalesTxt.setText(x);
}