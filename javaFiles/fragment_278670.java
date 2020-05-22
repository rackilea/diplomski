private static final class ParsingTreeCell
    extends TreeCell<MatchResult>
{
    @Override
    protected void updateItem(final MatchResult item, final boolean empty)
    {
        super.updateItem(item, empty);
        if (empty) {
            setText(null);
        } else {
            setText(item.getLabel() + " ("
                + (item.isSuccess() ? "SUCCESS" : "FAILURE") + ')');
        }
    }
}