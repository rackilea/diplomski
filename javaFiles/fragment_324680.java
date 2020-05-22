panel.add(createJButton("test", e -> classX.addNewTest()));

...

private JButton createJButton(String text, ActionListener listener) {
    JButton button = new JButton(text);
    button.addActionListener(listener);
    // more customization if needed
    return button;
}