final JXList list = new JXList(AncientSwingTeam.createNamedColorListModel());
JXTable table = new JXTable(new AncientSwingTeam());
final ColorHighlighter highlighter = new ColorHighlighter(
        HighlightPredicate.NEVER, Color.YELLOW, null);
list.addHighlighter(highlighter);
table.addHighlighter(highlighter);
ListSelectionListener l = new ListSelectionListener() {

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) return;
        highlighter.setHighlightPredicate(
                createPredicate(list.getSelectedValue()));
    }

    private HighlightPredicate createPredicate(Object selectedValue) {
        if (selectedValue == null) return HighlightPredicate.NEVER;
        return new HighlightPredicate.EqualsHighlightPredicate(selectedValue);
    }
};
list.getSelectionModel().addListSelectionListener(l);