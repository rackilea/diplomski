grid.getSelectionModel().addSelectionChangedHandler(new SelectionChangedHandler<Vo>() {

        @Override
        public void onSelectionChanged(SelectionChangedEvent<Vo> event) {
            if (grid.getSelectionModel().getSelectedItem() != null) {
                // Do whatever you want
            } else {

            }
        }
    });