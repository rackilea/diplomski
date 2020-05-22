table.getSelectionModel().selectedItemProperty().addListener(new 
ChangeListener<TreeItem<TestRow>>() {
        @Override public void changed(
                ObservableValue<? extends TreeItem<TestRow>> observable,
                TreeItem<TestRow> oldValue,
                TreeItem<TestRow> newValue) {
            if (newValue != null && newValue != oldValue) {
                System.out.println("Hello World");
            }
        }
});