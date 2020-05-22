public void removeElementAt(int index) {
    if ( getElementAt( index ) == selectedObject ) {
        if ( index == 0 ) {
            setSelectedItem( getSize() == 1 ? null : getElementAt( index + 1 ) );
        }
        else {
            setSelectedItem( getElementAt( index - 1 ) );
        }
    }

    objects.removeElementAt(index);

    fireIntervalRemoved(this, index, index);
}