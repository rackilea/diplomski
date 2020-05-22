final String value = "the name of leaf or branch";
Optional<TreeItem<String>> nodeOptional = branch.getChildren().stream()
                                                .filter(
                                                    (child)-> child.getValue().equals(value)
                                                 )
                                                .findFirst();

if (nodeOptional.isPresent()) {
    TreeItem<String> item = nodeOptional.get();
    // do something with item
} else {
    // no child with specified value was found
}