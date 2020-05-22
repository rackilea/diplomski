public class TagBar extends HBox {

    private final ObservableList<String> tags;
    private final TextField inputTextField;

    public ObservableList<String> getTags() {
        return tags;
    }

    public TagBar() {
        getStyleClass().setAll("tag-bar");
        getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        tags = FXCollections.observableArrayList();
        inputTextField = new TextField();
        inputTextField.setOnAction(evt -> {
            String text = inputTextField.getText();
            if (!text.isEmpty() && !tags.contains(text)) {
                tags.add(text);
                inputTextField.clear();
            }
        });

        inputTextField.prefHeightProperty().bind(this.heightProperty());
        HBox.setHgrow(inputTextField, Priority.ALWAYS);
        inputTextField.setBackground(null);

        tags.addListener((ListChangeListener.Change<? extends String> change) -> {
            while (change.next()) {
                if (change.wasPermutated()) {
                    ArrayList<Node> newSublist = new ArrayList<>(change.getTo() - change.getFrom());
                    for (int i = change.getFrom(), end = change.getTo(); i < end; i++) {
                        newSublist.add(null);
                    }
                    for (int i = change.getFrom(), end = change.getTo(); i < end; i++) {
                        newSublist.set(change.getPermutation(i), getChildren().get(i));
                    }
                    getChildren().subList(change.getFrom(), change.getTo()).clear();
                    getChildren().addAll(change.getFrom(), newSublist);
                } else {
                    if (change.wasRemoved()) {
                        getChildren().subList(change.getFrom(), change.getFrom() + change.getRemovedSize()).clear();
                    }
                    if (change.wasAdded()) {
                        getChildren().addAll(change.getFrom(), change.getAddedSubList().stream().map(Tag::new).collect(Collectors.toList()));
                    }
                }
            }
        });
        getChildren().add(inputTextField);
    }

    private class Tag extends HBox {

        public Tag(String tag) {
            getStyleClass().setAll("tag");
            Button removeButton = new Button("X");
            removeButton.setOnAction((evt) -> tags.remove(tag));
            Text text = new Text(tag);
            HBox.setMargin(text, new Insets(0, 0, 0, 5));
            getChildren().addAll(text, removeButton);
        }
    }

}