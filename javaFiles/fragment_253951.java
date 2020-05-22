final int items = 100;

// create items
String[] width = new String[items];
for(int i = 0; i < items; i++) width[i] = Integer.toString(i);

// create the panel
JPanel panel = new JPanel();
panel.setLayout(new GridLayout(2,1));
JLabel label = new JLabel("Choose Width");
JComboBox<String> cmbBox = new JComboBox<>(width);
cmbBox.setSelectedIndex(8);
panel.add(label);
panel.add(cmbBox);

// show dialog
int res = JOptionPane.showConfirmDialog(null, panel,
            "Select a Width", JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE, null);

// get selection
if(res == JOptionPane.OK_OPTION){
    String sel = String.valueOf(cmbBox.getSelectedItem());
    System.out.println("you selected: " + sel);
}