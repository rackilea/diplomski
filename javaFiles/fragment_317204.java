List<JCheckBox> boxes = new ArrayList<JCheckBox> ();
boxes.add(new JCheckBox("English"));
// populate the list with the other check boxes

String abbr = JComboBox<ComboItem> comboBox.getSelectedIndex().toString();
int index = Integer.parseInt(abbr);
boxes.get(index).setEnabled(true);