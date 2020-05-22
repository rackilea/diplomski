ComboBox<Consumer<String>> searchChoiceBox = new ComboBox<>();
searchChoiceBox.getItems().add(createSearchOption(this::searchFirstName, "First Name"));

// ...

private Consumer<String> createSearchOption(Consumer<String> search, String name) {
    return new Consumer<String>() {
        @Override
        public void accept(String s) {
            search.accept(s);
        }
        @Override
        public String toString() {
            return name ;
        }
    };
}