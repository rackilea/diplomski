.split-menu-button > .label {
    -fx-background-color:  -fx-outer-border, -fx-inner-border, -fx-body-color;
    -fx-background-insets: 0, 1 0 1 1, 2 1 2 2;
    -fx-background-radius: 5 0 0 5, 4 0 0 4, 3 0 0 3;
    -fx-padding: 0.166667em 0.667em 0.25em 0.833333em; /* 2 8 3 10 */
    /* -fx-graphic:url("./icon_32.png"); */
    -fx-content-display: top;
    -fx-alignment: center;
}
.split-menu-button:top > .label {
    -fx-background-insets: 0, 1 0 1 1, 2 1 2 2;
    -fx-background-radius: 0 0 5 5, 0 0 4 4, 0 0 3 3;
}
.split-menu-button:right > .label {
    -fx-background-insets: 0, 1 0 1 1, 2 1 2 2;
    -fx-background-radius: 5 0 0 5, 4 0 0 4, 3 0 0 3;
}
.split-menu-button:bottom > .label {
    -fx-background-insets: 0, 1 0 1 1, 2 1 2 2;
    -fx-background-radius: 5 5 0 0, 4 4 0 0, 3 3 0 0;
}
.split-menu-button:left > .label {
    -fx-background-insets: 0, 1 0 1 1, 2 1 2 2;
    -fx-background-radius: 0 5 5 0, 0 4 4 0, 0 3 3 0;
}
.split-menu-button:hidden > .label {
    -fx-background-insets: 0, 1 0 1 1, 2 1 2 2;
    -fx-background-radius: 5 5 5 5, 4 4 4 4, 3 3 3 3;
}
.split-menu-button > .arrow-button {
    -fx-background-color: -fx-outer-border, -fx-inner-border, -fx-body-color;
    -fx-background-insets: 0, 1, 2;
    -fx-background-radius: 0 5 5 0, 0 4 4 0, 0 3 3 0;
    -fx-padding: 0; /* 0.5em 0.667em 0.5em 0.667em; /* 6 8 6 8 */
    -fx-graphic:url("./arrow.png");
    -fx-alignment:center;
}
.split-menu-button:top > .arrow-button {
    -fx-background-insets: 0, 1, 2;
    -fx-background-radius: 5 5 0 0, 4 4 0 0, 3 3 0 0;
}
.split-menu-button:right > .arrow-button {
    -fx-background-insets: 0, 1, 2;
    -fx-background-radius: 0 5 5 0, 0 4 4 0, 0 3 3 0;
}
.split-menu-button:bottom > .arrow-button {
    -fx-background-insets: 0, 1, 2;
    -fx-background-radius: 0 0 5 5, 0 0 4 4, 0 0 3 3;
}
.split-menu-button:left > .arrow-button {
    -fx-background-insets: 0, 1, 2;
    -fx-background-radius: 5 0 0 5, 4 0 0 4, 3 0 0 3;
}