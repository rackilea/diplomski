.tree-view {
    -fx-background-color:lightsteelblue;
}

.tree-cell {
    -fx-background-color:lightsteelblue; // Default color
}

.tree-view:focused .tree-cell:filled:selected {
    -fx-background-color:indigo; // Focused color
}

.tree-cell:filled:selected{
    -fx-background-color:lightcyan; // Unfocused color
}