public static Data createPerson(Component comp) {
    NewPerson newPerson = new NewPerson();
    Window win = SwingUtilities.getWindowAncestor(comp);
    JDialog dialog = null;
    if (win instanceof Frame) {
        dialog = new JDialog((Frame) win, "New person", true);
    } else if (win instanceof Dialog) {
        dialog = new JDialog((Dialog) win, "New person", true);
    } else {
        dialog = new JDialog((Frame) null, "New person", true);
    }
    newPerson.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source instanceof Component) {
                Window win = SwingUtilities.getWindowAncestor((Component) source);
                win.dispose();
            }
        }
    });
    dialog.add(newPerson);
    dialog.setVisible(true);

    return newPerson.getData();
}