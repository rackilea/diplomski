Callback<TableColumn<Users, String>, TableCell<Users, String>> cellFactory
            = //
            new Callback<TableColumn<Users, String>, TableCell<Users, String>>() {
        @Override
        public TableCell call(final TableColumn<Users, String> param) {
            final TableCell<Users, String> cell = new TableCell<Users, String>() {

                final ChoiceBox createBox(){ 
ChoiceBox box = new ChoiceBox();
box.getItems.addAll("true" , "false");
box.setValue("true"); 

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        setGraphic(createBox);
                        setText(null);
                    }
                }
            };
            return cell;
        }
    };

    employCol.setCellFactory(cellFactory);