.table-row-cell:filled:selected,
.tree-table-row-cell:filled:selected,
.table-row-cell:filled > .table-cell:selected,
.tree-table-row-cell:filled > .tree-table-cell:selected,
.list-cell:filled:selected {
    -fx-background: orange;
}

.table-view:focused > .virtual-flow > .clipped-container > .sheet > .table-row-cell:filled:selected,
.tree-table-view:focused > .virtual-flow > .clipped-container > .sheet > .tree-table-row-cell:filled:selected,
.table-view:focused > .virtual-flow > .clipped-container > .sheet > .table-row-cell .table-cell:selected,
.tree-table-view:focused > .virtual-flow > .clipped-container > .sheet > .tree-table-row-cell .tree-table-cell:selected ,
.list-view:focused > .virtual-flow > .clipped-container > .sheet > .list-cell:filled:selected {
    -fx-background: -fx-selection-bar;
}