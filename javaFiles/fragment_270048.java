choBoxAddLR .getSelectionModel().selectedIndexProperty()
    .addListener(new ChangeListener<String>() {
      public void changed(ObservableValue ov, String value, String new_value) {
        // ...
      }
    });