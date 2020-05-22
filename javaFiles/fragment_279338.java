final Button btnHighlight = new Button("Highlight");
    btnHighlight.disableProperty().bind(Bindings.isEmpty(table.getSelectionModel().getSelectedIndices()));
    btnHighlight.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            highlightRows.setAll(table.getSelectionModel().getSelectedIndices());
        }
    });

    final Button btnClearHighlight = new Button("Clear Highlights");
    btnClearHighlight.disableProperty().bind(Bindings.isEmpty(highlightRows));
    btnClearHighlight.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            highlightRows.clear();
        }
    });