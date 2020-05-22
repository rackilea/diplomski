ComboBox<StringProperty> comboBox = new ComboBox<>();
comboBox.setItems(items);
comboBox.getSelectionModel().select(item1);

comboBox.setCellFactory(lv -> new StringPropertyCell());
comboBox.setButtonCell(new StringPropertyCell());