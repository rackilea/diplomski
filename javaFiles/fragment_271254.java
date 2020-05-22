private JScrollPane createComponent(String initial) {
    JTextArea ta = new JTextArea(3, 10);
    ta.setText(initial);
    JScrollPane sp = new JScrollPane(ta);

    Dimension pref = new Dimension(100, 100);
    sp.setPreferredSize(pref);
    //sp.setMaximumSize(pref);

    sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    return sp;
}