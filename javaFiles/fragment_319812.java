public List<JTextField> getAllJTextField(JComponent input) {
    List<JTextField> list = new ArrayList<JTextField>();
    for (Component c : input.getComponents()) {
        if (c.getClass().equals(JTextField.class)) {
            list.add((JTextField)c);
        }
    }
    return list;
}