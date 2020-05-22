JTextField number = new JTextField(5);
JTextField sum = new JTextField("0", 5);

setLayout(new GridBagLayout());
GridBagConstraints gbc = new GridBagConstraints();
gbc.gridwidth = GridBagConstraints.REMAINDER;

add(number, gbc);
add(sum, gbc);

DeferredDocumentChangedListener listener = new DeferredDocumentChangedListener();
listener.addChangeListener(new ChangeListener() {

    @Override
    public void stateChanged(ChangeEvent e) {
        int num1 = Integer.parseInt(number.getText());
        int num2 = Integer.parseInt(sum.getText());
        int result = num1 + num2;
        sum.setText(Integer.toString(result));
        number.selectAll();
    }
});

number.getDocument().addDocumentListener(listener);