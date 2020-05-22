listView.setCellFactory(lv -> {
    ListCell<Todo> cell = new ListCell<Todo>() {
        @Override
        protected void updateItem(Todo item, boolean empty) {
            super.updateItem(item, empty);
            setText(item == null ? "" : item.toString());
        }
    };
    cell.setOnMouseClicked(e -> {
        if (! cell.isEmpty()) {
            StageController.launchSelectedTodoStage(cell.getItem());
        }
    });
    return cell ;
});