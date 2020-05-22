treeView.setCellFactory(new Callback<TreeView<File>, TreeCell<File>>() {

    public TreeCell<File> call(TreeView<File> tv) {
        return new TreeCell<File>() {

            @Override
            protected void updateItem(File item, boolean empty) {
                super.updateItem(item, empty);

                setText((empty || item == null) ? "" : item.getName());
            }

        };
    }
});