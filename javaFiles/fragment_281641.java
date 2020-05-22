class OpenBrowserAction extends AbstractAction {
    public OpenBrowserAction(String name, int mnemonic) {
        super(name);
        putValue(MNEMONIC_KEY, mnemonic);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Open Browswer");
    }
}