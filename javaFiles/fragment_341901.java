int[] gridRowHeights = MaxCellBoundsHelper.getPreferredRowHeights(
        this.nattable.getConfigRegistry(),
        new GCFactory(this.nattable),
        this.nattable,
        new int[] { 0 });

if (gridRowHeights != null) {
    this.nattable.doCommand(
        new MultiRowResizeCommand(this.nattable, new int[] { 0 }, gridRowHeights, true));
}