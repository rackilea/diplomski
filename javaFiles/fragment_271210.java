public ListCell<T> call(final ListView<T> param) {
    ListCell<T> cell = new ListCell<T>(){
        @Override
        protected void updateItem(final T persistentObject, final boolean empty) {
            super.updateItem(persistentObject, empty);
            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                // ... rest of your code.
            }
       }
    }
    return cell ;
}