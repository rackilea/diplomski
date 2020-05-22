Callback<TableColumn<Map.Entry<PropertyDifference, DifferenceFileList>, String>, TableCell<Map.Entry<PropertyDifference, DifferenceFileList>, String>> tableCellList = new Callback<TableColumn<Map.Entry<PropertyDifference, DifferenceFileList>, String>, TableCell<Map.Entry<PropertyDifference, DifferenceFileList>, String>>() {
        @Override
        public TableCell<Map.Entry<PropertyDifference, DifferenceFileList>, String> call(TableColumn<Map.Entry<PropertyDifference, DifferenceFileList>, String> param) {
            return new TableCell<Map.Entry<PropertyDifference, DifferenceFileList>, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                  if (item != null) {
                      item = item.replace("[", "") .replace("]", "");
                      ObservableList<String> items = FXCollections.observableArrayList(item.split(","));
                      final ListView<String> listView = new ListView<String>();

                      listView.setItems(items);

                      setGraphic(listView);
                  }
                }
            };
        }
    };

    arrayListCol.setCellFactory(tableCellList);