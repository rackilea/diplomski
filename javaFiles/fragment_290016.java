.text-area {
    -fx-focus-color: transparent;
    -fx-faint-focus-color: transparent;
}

.text-area .content {
    -fx-background-color:-fx-control-inner-background;
}
.text-area:focused .content {
    -fx-background-color:-fx-control-inner-background;
}

.text-area:focused {
    -fx-background-color: linear-gradient(to bottom, derive(-fx-text-box-border, -10%), -fx-text-box-border), -fx-control-inner-background;
    -fx-background-insets: 0, 1;
    -fx-background-radius: 3, 2;
}