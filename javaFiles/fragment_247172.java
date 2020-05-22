final JTextField textField = new JTextField(15);

JDateChooser chooser = new JDateChooser();
chooser.setLocale(Locale.US);

chooser.addPropertyChangeListener("date", new PropertyChangeListener() {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        JDateChooser chooser = (JDateChooser)evt.getSource();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        textField.setText(formatter.format(chooser.getDate()));
    }
});

JPanel content = new JPanel();
content.add(chooser);
content.add(textField);

JDialog dialog = new JDialog ();
dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
dialog.getContentPane().add(content);
dialog.pack();
dialog.setLocationRelativeTo(null);
dialog.setVisible(true);