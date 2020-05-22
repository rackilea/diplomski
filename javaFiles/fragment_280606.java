class ModelContentProvider implements IStructuredContentProvider {

    @SuppressWarnings("unchecked")
    @Override
    public Object[] getElements(Object inputElement) {
        // The inputElement comes from view.setInput()
        if (inputElement instanceof List) {
            List models = (List) inputElement;
            return models.toArray();
        }
        return new Object[0];
    }

/* ... other methods */

}