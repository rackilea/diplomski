JToolBar tools = new JToolBar();
tools.setFloatable(false);
// adds tools to JPanel gui made in another method
gui.add(tools, BorderLayout.PAGE_START);

addButtonToToolbar(tools, "New", e -> System.out.println("Pressed New"));
addButtonToToolbar(tools, "Save", e -> System.out.println("Pressed Save"));
addButtonToToolbar(tools, "Restore", e -> System.out.println("Pressed Restore"));
tools.addSeparator();
addButtonToToolbar(tools, "Quit", e -> System.out.println("Pressed Quit"));


private void addButtonToToolbar(final JToolBar toolBar, final String buttonText,
                                final ActionListener actionListener) {
    final JButton button = new JButton(buttonText);
    button.addActionListener(actionListener);
    toolBar.add(button);
}