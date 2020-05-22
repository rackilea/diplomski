.highlighted-table-cell {
    -fx-background-color: rgba(0, 128, 0, 0.3);
}

/* Needed by cell selection mode */
.highlighted-table-cell:selected {
    -fx-background-color: inherit;
}

/* Needed by row selection mode */
.table-row-cell:selected > .highlighted-table-cell {
    -fx-background-color: inherit;
}