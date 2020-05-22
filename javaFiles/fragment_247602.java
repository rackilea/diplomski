.titled-pane > .title {
    -fx-background-color:
        linear-gradient(to bottom,
            derive(-fx-color,-15%) 95%,
            derive(-fx-color,-25%) 100%
        ),
        -fx-inner-border, -fx-body-color;
    -fx-background-insets: 0, 1, 2;
    -fx-background-radius: 3 3 0 0, 2 2 0 0, 1 1 0 0;
    -fx-padding: 0.3333em 0.75em 0.3333em 0.75em; /* 4 9 4 9 */
}

.titled-pane > .title:hover {
    -fx-color: -fx-hover-base;
}