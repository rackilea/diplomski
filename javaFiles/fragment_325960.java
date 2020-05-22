public class DeferredDocumentChangedListener implements DocumentListener {

    private Timer timer;
    private List<ChangeListener> listeners;

    public DeferredDocumentChangedListener() {

        listeners = new ArrayList<>(25);
        timer = new Timer(250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireStateChanged();
            }
        });
        timer.setRepeats(false);
    }

    public void addChangeListener(ChangeListener listener) {
        listeners.add(listener);
    }

    public void removeChangeListener(ChangeListener listener) {
        listeners.add(listener);
    }

    protected void fireStateChanged() {
        if (!listeners.isEmpty()) {
            ChangeEvent evt = new ChangeEvent(this);
            for (ChangeListener listener : listeners) {
                listener.stateChanged(evt);
            }
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        timer.restart();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        timer.restart();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        timer.restart();
    }

}