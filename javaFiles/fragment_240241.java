// Color of the list-cell selected + unselected: transparent
.list-view .list-cell,
.list-view .list-cell:filled,
.list-view .list-cell:selected,
.list-view .list-cell:focused,
 .list-view .list-cell:hover {
    -fx-background-color: transparent;
    -fx-effect: null;
}

// Color of the custom control hover
.list-view .list-cell:hover .email-view {
    -fx-background-color: greenyellow;
}

// Color of the custom control selected
.list-view .list-cell:filled:selected:focused .email-view,
.list-view .list-cell:filled:selected .email-view {
    -fx-background-color: green;
}

// Color of the custom control unselected
.email-view { -fx-background-color: gray; }