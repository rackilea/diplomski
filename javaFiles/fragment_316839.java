private static final int N = 31;
…
List<JSpinner> list = new ArrayList<>();
JPanel p = new JPanel(new GridLayout(N, 0));
for (int i = 0; i < N; i++) {
    p.add(createSpinnerPanel(list, i));
}
…
private JPanel createSpinnerPanel(List<JSpinner> list, int i) {
    JSpinner s = new JSpinner();
    list.add(s);
    JFormattedTextField f = (JFormattedTextField) s.getEditor().getComponent(0);
    f.setColumns(4);
    JPanel p = new JPanel(new GridLayout(0, 2));
    p.add(new JLabel("Label " + String.valueOf(i + 1) + ": ", JLabel.RIGHT));
    p.add(s);
    return p;
}