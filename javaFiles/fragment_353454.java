public class ShowEventsAction extends AbstractAction implements LookupListener, ContextAwareAction {

    private Lookup context;
    Lookup.Result<ShowAuditEventsCapability> lkpInfo;

    public ShowEventsAction() {
        this(Utilities.actionsGlobalContext());
    }

    public ShowEventsAction(Lookup context) {
        super("Show Audit Events", ImageUtilities.loadImageIcon("it/cre/myapp/audittree/actions/show.png", false));
        this.context = context;
    }

    void init() {
        assert SwingUtilities.isEventDispatchThread() : "this shall be called just from AWT thread";

        if (lkpInfo != null) {
            return;
        }

        //The thing we want to listen for the presence or absence of
        //on the global selection
        lkpInfo = context.lookupResult(ShowAuditEventsCapability.class);
        lkpInfo.addLookupListener(this);
        resultChanged(null);
    }

    @Override
    public boolean isEnabled() {
        init();
        return super.isEnabled();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        init();
        for (ShowAuditEventsCapability showAuditEventsCapability : lkpInfo.allInstances()) {
            showAuditEventsCapability.doSomething();
        }
    }

    @Override
    public void resultChanged(LookupEvent ev) {
        int selected = lkpInfo.allInstances().size();

        if (selected == 0) {
            setEnabled(false);
            return;
        }

        for (EasyDbNode node : Utilities.actionsGlobalContext().lookupAll(INode.class)) {
            if (!node.isEnabled()) {
                setEnabled(false);
                return;
            }
        }
        setEnabled(true);
    }

    @Override
    public Action createContextAwareInstance(Lookup actionContext) {
        return new ShowEventsAction(context);
    }
}