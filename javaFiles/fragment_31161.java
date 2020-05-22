pane1.getChildren().stream()
    .map(Label.class::cast)
    .map(Label::getText)
    .forEach(text -> {
        // whatever you need to do with text...
    });