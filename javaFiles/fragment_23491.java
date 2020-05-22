if (table.getRowSorter() != null && table.getRowSorter().getSortKeys() != null && !table.getRowSorter().getSortKeys().isEmpty() &&
        table.getRowSorter().getSortKeys().get(0).getColumn() == column)
{
    if (table.getRowSorter().getSortKeys().get(0).getSortOrder() == SortOrder.ASCENDING)
    {
        label_.setText(String.valueOf(value) + "  \u25b2");
    }
    else if (table.getRowSorter().getSortKeys().get(0).getSortOrder() == SortOrder.DESCENDING)
    {
        label_.setText(String.valueOf(value) + "  \u25bc");
    }
}
else
{
    label_.setText(String.valueOf(value));
}