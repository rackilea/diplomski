public void addElement(Object anObject) {
    objects.addElement(anObject);
    fireIntervalAdded(this,objects.size()-1, objects.size()-1);
    if ( objects.size() == 1 && selectedObject == null && anObject != null ) {
        setSelectedItem( anObject );
    }
}