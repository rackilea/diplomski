commentColumn.setCellFactory(new Callback<TableColumn<Store, Number>, new TableCell<Store, Number>>() {
    @Override
    public TableCell<Store, Number>() {
        private ImageView imageView = new ImageView();

        @Override
        public void updateItem(Number numberOfComments, boolean empty) {
            super.updateItem(count, empty) ;
            if (empty) {
                setGraphic(null);
            } else {
                if (numberOfComments.intValue() == 0) {
                    setGraphic(null);
                } else if (numberOfComments.intValue() == 1) {
                    imageView.setImage(new Image(COMMENT_SINGLE_FLAG_SOURCE));
                    setGraphic(imageView);
                } else {
                    imageView.setImage(new Image(COMMENT_DOUBLE_FLAG_SOURCE));
                    setGraphic(imageView);
                }
            }
        }
    }
});