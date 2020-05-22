class MyJTextField extends JTextField {

    // Initialization block that is called for all the constructors
    {
        this.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                selectAll();
            }
        });
        this.setHorizontalAlignment(JTextField.CENTER);
    }

    public MyJTextField() {}
    public MyJTextField(String text) {super(text);}
    public MyJTextField(int columns) {super(columns);}
    public MyJTextField(String text, int columns) {super(text, columns);}
}