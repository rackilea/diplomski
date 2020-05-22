class Passage {
    private Action action;

    private StringProperty actionMyStringProperty = new SimpleStringProperty();

    void setAction(Action action) {
        this.action = action;

        // Unbind the previous binding if any (it is safe when nothing to unbind).
        actionMyStringProperty.unbind();

        if (action != null){
            actionMyStringProperty.bind(action.getStringProperty());
        }
    }

    public StringProperty actionMyStringProperty() {
        return actionMyStringProperty;
    }
}

class Action {
    private StringProperty myStringProperty = new SimpleStringProperty();

    StringProperty getStringProperty() {
        return myStringProperty;
    }
}