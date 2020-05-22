itemTypeCol.setCellValueFactory(new PropertyValueFactory<Details, String>("ItemType"));
itemColorCol.setCellValueFactory(new PropertyValueFactory<Details, String>("ItemColor"));

description.setCellValueFactory(new PropertyValueFactory<Details, String>("Description"));

tableView.setItems(data);