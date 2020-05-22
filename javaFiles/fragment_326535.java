newsList.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
    @Override 
    public ListCell<String> call(ListView<String> list) {
        return new YourFormatCell();
    }
});