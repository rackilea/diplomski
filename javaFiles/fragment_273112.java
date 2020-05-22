public class AmountDialog extends Dialog<SubModel> {

    public AmountDialog(SubModel model) {
        setTitle("Title");
        setHeaderText("Header");
        getDialogPane().setContent(createContent(model));
        setResultConverter(button -> {
            if (button == ButtonType.OK) {
                return model;
            }
            return null;
        });
    }

    private GridPane createContent(SubModel model) {
        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 10, 10));
        Label sub = new Label("Sub");
        Label amount = new Label("Amount");

        Label amountX = new Label("AmountX");
        Label amountY = new Label("AmountY");

        TextField tfAmounX = new TextField(String.valueOf(model.getxAmount()));
        TextField tfAmountY = new TextField(String.valueOf(model.getyAmount()));

        Bindings.bindBidirectional(tfAmounX.textProperty(), model.xAmountProperty(), new StringDoubleConverter());
        Bindings.bindBidirectional(tfAmountY.textProperty(), model.yAmountProperty(), new StringDoubleConverter());

        grid.add(sub, 0, 0);
        grid.add(amount, 1, 0);

        grid.add(amountX, 0, 1);
        grid.add(tfAmounX, 1, 1);

        grid.add(amountY, 0, 2);
        grid.add(tfAmountY, 1, 2);

        return grid;
    }

    private class StringDoubleConverter extends StringConverter<Number> {
        @Override public String toString(Number object) {
            return object.toString();
        }

        @Override public Number fromString(String string) {
            // You may handle NumberFormatException.
            return Double.valueOf(string);
        }
    }
}