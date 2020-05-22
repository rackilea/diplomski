class AboutAction extends AbstractAction {
    private MyMain myMain;

    public AboutAction(String name, int mnemonic, MyMain myMain) {
        super(name);
        putValue(MNEMONIC_KEY, mnemonic);
        this.myMain = myMain;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (myMain != null) {
            myMain.showPanel(MyMain.ABOUT_PANEL);
        }
    }
}