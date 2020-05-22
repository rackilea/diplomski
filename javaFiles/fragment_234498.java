table.setRowFactory(tv -> new TableRow<myTextRow>() {
    {
        setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getButton() == MouseButton.PRIMARY
                    && mouseEvent.getClickCount() == 2
                    && !isEmpty()
                    && getItem() == addPlaceHolder) {
                data.add(data.size() - 1, new myTextRow(td_get_biggest_ID() + 1, "", ""));
                table.selectionModelProperty().get().select(data.size() - 1);
                mouseEvent.consume();
            }
        });
    }

    @Override
    protected void updateItem(myTextRow item, boolean empty) {
        super.updateItem(item, empty);

        // add style class for row containing addPlaceHolder
        List<String> classes = getStyleClass();
        final String clazz = "add-row";

        if (item == addPlaceHolder) {
            if (!classes.contains(clazz)) {
                classes.add(clazz);
            }
        } else {
            classes.remove(clazz);
        }
    }
});