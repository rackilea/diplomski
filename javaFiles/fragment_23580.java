public class ProxyAction extends AbstractAction {

    private Action action;

    public ProxyAction(Action action) {
        this.action = action;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        action.actionPerformed(e);
        System.out.println("Paste Occured...");
    }

}