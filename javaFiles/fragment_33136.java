ObservableList<String> list = FXCollections.observableArrayList();
list.addListener(/* your listener */);
names.put("1", list);

// OR

// Less efficient since you have to perform a lookup
// in order to add the listener.
names.put("1", FXCollections.observableArrayList());
names.get("1").addListener(/* your listener */);