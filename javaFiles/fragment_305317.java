protected void updateItem(MyObject t, boolean bln) {
    super.updateItem(t, bln);

    if (t != null) {
        label1.setText("Label 1");
        label2.setText("Label 2");

        setGraphic(graphic);
    } else {
        setGraphic(null);
    }
}