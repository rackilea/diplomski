class Model {

    void addModelListener(ModelListener listener) { ... }

    String getValue() { ... }

    void setValue(String newValue) {
        ....
        // Notify all ModelListeners here...
    }
}