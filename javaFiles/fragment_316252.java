.tree-cell, .list-cell {
    -fx-background-color: rgb(243, 243, 243);
}

.tree-cell:empty {
    -fx-graphic: none;
}

.tree-cell:playlist {
    -fx-graphic: url('../playlist-black-icon.png');
}

.tree-cell:playlist-selected {
    -fx-graphic: url('../playlist-white-icon.png');
}

.tree-cell:folder {
    -fx-graphic: url('../playlist-folder-black-icon.png');
}

.tree-cell:folder-selected {
    -fx-graphic: url('../playlist-folder-white-icon.png');
}

.tree-cell:playlist-selected, .tree-cell:folder-selected {
    -fx-background-color: black;
    -fx-text-fill: white;
}