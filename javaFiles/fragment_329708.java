@SuppressWarnings("serial")
class CardAction extends AbstractAction {
    private ActionListener listener;

    public CardAction(String name, int mnemonic, ActionListener listener) {
        super(name);
        putValue(MNEMONIC_KEY, mnemonic);
        this.listener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        listener.actionPerformed(e);
    }
}