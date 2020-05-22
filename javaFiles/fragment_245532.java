scene.focusOwnerProperty().addListener(new ChangeListener<Node>() {
        @Override
        public void changed(ObservableValue<? extends Node> ov, Node t, Node t1) {

            if (t1 == table2) {
                table1.getSelectionModel().clearSelection();
            }
            if (t1 == table1) {
                table2.getSelectionModel().clearSelection();
            }
        }
    });