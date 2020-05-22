.header {
    -fx-background-color: darkorange;
    -fx-pref-height: 30;
    -fx-padding: 5 0 0 0;
}

.header > .label {
    -fx-text-fill: white;
}

.header > .label, .content-header > .text-field {
    -fx-alignment: center;
    -fx-text-alignment: center;
}

.content-header > .text-field, .content-header > .text-field:focused {
    /* Make the TextField's display similar to a Label */
    -fx-background-color: transparent;
}

.content-header, .titled-pane > .title, .table-view {
    -fx-background-color: white;
}

.titled-pane > .title {
    -fx-border-color: lightgray;
    -fx-border-width: 0 0 1 0;
}

.table-view {
     -fx-table-cell-border-color: transparent;
}

.table-view .column-header-background {
    -fx-border-radius: 5 5 0 0;
    -fx-background-radius: 5 5 0 0;
}

.table-view .column-header-background, .table-row-cell {
    -fx-background-color: lightgray;
    -fx-border-color: gray;
    -fx-border-width: 0 0 1 0;
}

.table-view .column-header-background .label {
    -fx-background-color: lightgray;
    -fx-text-fill: black;
    -fx-font-weight: bold;
}

.table-view .column-header {
    -fx-background-color: transparent;
}

.table-column {
    -fx-alignment: center;
}