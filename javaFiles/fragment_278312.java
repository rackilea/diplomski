public DefaultComboBoxModel(Vector<?> v) {
    objects = v;

    if ( getSize() > 0 ) {
        selectedObject = getElementAt( 0 );
    }
}