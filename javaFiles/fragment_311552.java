final JXList list = new JXList(new DefaultComboBoxModel(Locale.getAvailableLocales()));
list.setAutoCreateRowSorter(true);
final List<RowFilter> filters = new ArrayList<>();
filters.add(new MyRowFilter("de"));
filters.add(new MyRowFilter("ar"));
final List<JCheckBox> boxes = new ArrayList<>();
ActionListener l = new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        List<RowFilter<Object, Object>> orCandidates = new ArrayList<>();
        for (int i = 0; i < boxes.size(); i++) {
            if (boxes.get(i).isSelected())
                orCandidates.add(filters.get(i));
        }
        RowFilter<Object, Object> or = orCandidates.isEmpty() ? null :
            RowFilter.orFilter(orCandidates);
        list.setRowFilter(or);
    }

};
JCheckBox first = new JCheckBox("de");
first.addActionListener(l);
boxes.add(first);
JCheckBox second = new JCheckBox("ar");
second.addActionListener(l);
boxes.add(second);

JComponent content = new JPanel();
content.add(new JScrollPane(list));
for (JCheckBox box : boxes) {
    content.add(box);
}
showInFrame(content, "filters");

// just for completeness, the custom RowFilter
public static class MyRowFilter extends RowFilter {

    private String text;
    public MyRowFilter(String text) {
        this.text = text;
    }
    @Override
    public boolean include(Entry entry) {
        Locale locale = (Locale) entry.getValue(0);
        return locale.getLanguage().contains(text);
    }

}