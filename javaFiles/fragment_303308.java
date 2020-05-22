/**
 * Empty Action with enabled state that's the OR'ed enabled of all contained actions.
 */
public static class OrEnabledEmptyAction extends AbstractAction {

    private List<Action> actions;

    public OrEnabledEmptyAction(Collection<Action> actions, String name) {
        super(name);
        this.actions = new ArrayList<>(actions);
        installEnabledListener();
        updateEnabled();
    }

    /**
     * Updates this Action's enabled state dependent on enabled of
     * contained actions.
     */
    private void updateEnabled() {
        boolean enabled = false;
        for (Action action : actions) {
            enabled |= action.isEnabled();
        }
        setEnabled(enabled);
    }

    /**
     * Installs a PropertyChangeListener which updates this Action's 
     * enabled state on notification of enabled of contained actions.
     */
    private void installEnabledListener() {
        PropertyChangeListener l = new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("enabled".equals(evt.getPropertyName()))
                    updateEnabled();
            }

        };
        for (Action action : actions) {
            action.addPropertyChangeListener(l);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // does nothing, never called for a JMenu anyway
    }

}