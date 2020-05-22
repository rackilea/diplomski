final Image image = new Image("img/folder.png");

listView.setCellFactory(new Callback<ListView<File>, ListCell<File>>() {
    @Override
    public ListCell<File> call(ListView<File> list) {
        return new ListCell<File>() {
            private final ImageView imageView = new ImageView(image);
            @Override
            protected void updateItem(File t, boolean bln) {
                super.updateItem(t, bln);
                if (t == null) {
                    setGraphic(null);
                    setText(null);
                } else {
                    setGraphic(imageView);
                    setText(t.getName());
                }
            }

        };
    }
});