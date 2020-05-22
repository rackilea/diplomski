Color background = unselectedBackground != null
                        ? unselectedBackground
                        : table.getBackground();
if (background == null || background instanceof javax.swing.plaf.UIResource) {
    Color alternateColor = DefaultLookup.getColor(this, ui, "Table.alternateRowColor");
    if (alternateColor != null && row % 2 != 0) {
        background = alternateColor;
    }
}