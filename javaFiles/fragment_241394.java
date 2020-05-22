.titled-pane {
    -fx-collapsible: false;
    -fx-content-display: right;
    -fx-graphic-text-gap: 10px;
}

.titled-pane > .title,
.titled-pane > .content {
    -fx-background-color: white;
    -fx-border-style: solid;
    -fx-border-color: black;
    -fx-border-width: 1px;
}

.titled-pane > .title:hover > .button {
    -fx-color: -fx-base;
}

.titled-pane > .title:hover > .button:hover {
    -fx-color: -fx-hover-base;
}

.titled-pane > .title:hover > .button:armed {
    -fx-color: -fx-pressed-base;
}