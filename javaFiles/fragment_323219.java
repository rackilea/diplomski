//Constant declared somewhere in the class
private static final int SELECTED_ITEMS_LIMIT = 4;

...

table.addListener(new Property.ValueChangeListener() {

    @Override
    public void valueChange(ValueChangeEvent event) {
        Collection selectedItems = (Collection) event.getProperty().getValue();
        if(selectedItems.size()>SELECTED_ITEMS_LIMIT) { //Set no more than SELECTED_ITEMS_LIMIT values
            Set<String> noMoreThanLimitItems = new HashSet<String>(selectedItems.size());
            int counter = 0;
            for(Object item : selectedItems) {
                if(counter>=SELECTED_ITEMS_LIMIT) {
                    break;
                }
                noMoreThanLimitItems.add((String) item);
                counter++;
            }
            event.getProperty().setValue(noMoreThanLimitItems);
        }  
    }
});