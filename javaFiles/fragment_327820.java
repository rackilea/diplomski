public void removeAllItems() {
    checkMutableComboBoxModel();
    MutableComboBoxModel<E> model = (MutableComboBoxModel<E>)dataModel;
    int size = model.getSize();

    if ( model instanceof DefaultComboBoxModel ) {
        ((DefaultComboBoxModel)model).removeAllElements();
    }
    else {
        for ( int i = 0; i < size; ++i ) {
            E element = model.getElementAt( 0 );
            model.removeElement( element );
        }
    }
    selectedItemReminder = null;
    if (isEditable()) {
        editor.setItem(null);
    }
}