jList1 = new javax.swing.JList();
//String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
jList1.setModel(new javax.swing.AbstractListModel() {
    String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
    Vector v = makeVectorData(strings);
    public int getSize() { return v.size(); }
    public Object getElementAt(int i) { return v.get(i); }
});
jList1.setCellRenderer(new JlistRenderer());
jList1.addFocusListener(new JListFocusListener(jList1)); 

 public class JlistRenderer extends JLabel implements ListCellRenderer { JSeparator separator; final String SEPARATOR = "SEPARATOR"; public JlistRenderer() { setOpaque(true); setBorder(new EmptyBorder(1, 1, 1, 1)); separator = new JSeparator(JSeparator.HORIZONTAL); } public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) { String str = (value == null) ? "" : value.toString(); if (SEPARATOR.equals(str)) { return separator; } if (isSelected) { setBackground(list.getSelectionBackground()); setForeground(list.getSelectionForeground()); } else { setBackground(list.getBackground()); setForeground(list.getForeground()); } setFont(list.getFont()); setText(str); return this; } }

 public class JListFocusListener implements FocusListener { JList list; Object currentItem; final String SEPARATOR = "SEPARATOR"; JListFocusListener(JList list) { this.list= list; list.setSelectedIndex(0); currentItem = list.getSelectedValue(); } public void focusGained(FocusEvent e) { String tempItem = (String) list.getSelectedValue(); if (SEPARATOR.equals(tempItem)) { list.setSelectedValue(currentItem,true); } else { currentItem = tempItem; } } }