int[] gridRowHeights1 = MaxCellBoundsHelper.getPreferredRowHeights(
        ExampleNatTable.this.nattable.getConfigRegistry(),
        new GCFactory(ExampleNatTable.this.nattable),
        ExampleNatTable.this.nattable,
        new int[] { 0 });
int[] gridRowHeights2 = MaxCellBoundsHelper.getPreferredRowHeights(
        ExampleNatTable.this.nattable.getConfigRegistry(),
        new GCFactory(ExampleNatTable.this.nattable),
        ExampleNatTable.this.nattable,
        new int[] { 1 });

if (gridRowHeights1 != null) {
    ExampleNatTable.this.nattable.doCommand(
            new MultiRowResizeCommand(
                    ExampleNatTable.this.nattable,
                    new int[] { 0 },
                    gridRowHeights1));
}
if (gridRowHeights2 != null) {
    ExampleNatTable.this.nattable.doCommand(
            new MultiRowResizeCommand(
                    ExampleNatTable.this.nattable,
                    new int[] { 1 },
                    gridRowHeights2));
}