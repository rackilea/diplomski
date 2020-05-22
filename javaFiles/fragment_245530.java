mainTableView2.focusModelProperty().addListener(new ChangeListener() {

        @Override
        public void changed(ObservableValue ov, Object t, Object t1) {
            mainTableView1.getSelectionModel().clearSelection();
        }
    });