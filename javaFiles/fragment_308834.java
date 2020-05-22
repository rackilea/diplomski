sendRightButton.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
            ObservableList<String> potential = 
                FXCollections.observableArrayList( //copy
                    candidatesListView.getSelectionModel().getSelectedItems());
            if (potential != null) {
                heroes.addAll(potential);
                candidates.removeAll(potential);
                candidatesListView.getSelectionModel().clearSelection();
            }
        }
    });