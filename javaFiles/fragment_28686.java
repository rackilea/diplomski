tableActors.setCellFactory(tc -> new TableCell<Movie, String[]>() {
    @Override
    protected void updateItem(String[] actors, boolean empty) { 
        super.updateItem(actors, empty);
        if (empty || actors == null) {
            setText(null);
        } else {
            setText(String.join(", ", actors));
        }
    }
});