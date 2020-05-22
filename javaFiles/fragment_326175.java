// General scroll style
.scroll-bar:horizontal .thumb,
.scroll-bar:vertical .thumb {
    -fx-background-color : #dddddd;
    -fx-background-insets : 2.0, 0.0, 0.0;
    -fx-background-radius : 0em;
}

.scroll-bar:horizontal .thumb:hover,
.scroll-bar:vertical .thumb:hover {
    -fx-background-color : #9e9e9e;
    -fx-background-insets : 2.0, 0.0, 0.0;
    -fx-background-radius : 0em;
}

// Custom ScrollPane style
.rounded-scroll-pane > .scroll-bar:horizontal .thumb,
.rounded-scroll-pane > .scroll-bar:vertical .thumb {
    -fx-background-color : #dddddd;
    -fx-background-insets : 2.0, 0.0, 0.0;
    -fx-background-radius : 2em;
}

.rounded-scroll-pane > .scroll-bar:horizontal .thumb:hover,
.rounded-scroll-pane > .scroll-bar:vertical .thumb:hover {
    -fx-background-color : #9e9e9e;
    -fx-background-insets : 2.0, 0.0, 0.0;
    -fx-background-radius : 2em;
}