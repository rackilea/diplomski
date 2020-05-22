class ExitAction extends AbstractAction {
    public ExitAction(String name, int mnemonic) {
        super(name);
        putValue(MNEMONIC_KEY, mnemonic);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Component comp = (Component) e.getSource();
        if (comp != null) {
            Window win = SwingUtilities.getWindowAncestor(comp);
            if (win != null) {
                win.dispose();
            }
        }
    }
}