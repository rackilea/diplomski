public class DefaultTextModel implements TextModel {

    private String text;
    private Set<ChangeListener> listeners;

    public DefaultTextModel() {
        listeners = new HashSet<>(25);
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String value) {
        if (text == null ? value != null : !text.equals(value)) {
            this.text = value;
            fireStateChanged();
        }
    }

    @Override
    public void addChangeListener(ChangeListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeChangeListener(ChangeListener listener) {
        listeners.remove(listener);
    }

    protected void fireStateChanged() {
        ChangeListener[] changeListeners = listeners.toArray(new ChangeListener[0]);
        if (changeListeners != null && changeListeners.length > 0) {
            ChangeEvent evt = new ChangeEvent(this);
            for (ChangeListener listener : changeListeners) {
                listener.stateChanged(evt);
            }
        }
    }

}

public class DefaultTextController implements TextController {

    private TextModel model;
    private TextView view;

    public DefaultTextController(TextModel model, TextView view) {
        this.model = model;
        this.view = view;

        this.view.setController(this);
        this.model.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // You could simply make a "textWasChanged" method on the view
                // and make the view ask the controller for the value, but where's
                // the fun in that :P
                getView().setText(getText());
            }
        });
    }

    public TextModel getModel() {
        return model;
    }

    public TextView getView() {
        return view;
    }

    @Override
    public String getText() {
        return getModel().getText();
    }

    @Override
    public void setText(String text) {
        getModel().setText(text);
    }

}