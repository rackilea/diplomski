button1.addActionListener(new ActionListener() {
    public void actionPerformed(final ActionEvent s) {
        s.getActionCommand();

        Component source = (Component) s.getSource();

        Container parent = source.getParent();// will give the container of the button

        do {

            parent = parent.getParent();

        } while (!(parent instanceof JTabbedPane));

        JTabbedPane tabbedPane = (JTabbedPane)parent;

        // How can i switch to Tab xy?
        tabbedPane.setSelectedIndex(xyIndex);

        System.out.println("Switch Tab");
    }
});