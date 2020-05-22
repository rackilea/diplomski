ButtonModel toggle = new ButtonModel();
...
JButton button = new JButton(toggle);
...
// this is clear that we are manipulating the model, not the view
// as new views are added / removed, this toggle will continue to work
toggle.setEnabled(!toggle.isEnabled());