YourObject yourObject = yourTableView.getSelectionModel().getSelectedItem();
TextField editfirstnameinput = new TextField();
editfirstnameinput.setText(yourObject.getFirstName());
TextField editlastnameinput = new TextField();
editlastnameinput.setText(yourObject.getLastName());
TextField editemailinput = new TextField();
editemailinput.setText(yourObject.getEmail());