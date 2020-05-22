public List<Object> elements;
public List<ObservableListListener> listListeners;

    abstract boolean acceptsElement(Object element);

    protected void addElement(int index, Object element) {
        if (acceptsElement(element)) {
            elements.add(index, element);

        // update listeners with new list and position of change
        for (ObservableListListener listListener : listListeners) {
            listListener.listChanged(this, index);
        }
    } else 
        throw new IllegalArgumentException("!acceptsElement()");
}

protected void addElement(Object element) {
    if (acceptsElement(element)) {
        elements.add(element);

        // update listeners with new list and position of change
        for (ObservableListListener listListener : listListeners) {
            listListener.listChanged(this, elements.indexOf(element));
        }
    } else 
        throw new IllegalArgumentException("!acceptsElement()");
}