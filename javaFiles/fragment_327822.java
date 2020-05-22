public void removeAllElements() {
    if ( objects.size() > 0 ) {
        int firstIndex = 0;
        int lastIndex = objects.size() - 1;
        objects.removeAllElements();
        selectedObject = null;
        fireIntervalRemoved(this, firstIndex, lastIndex);
    } else {
        selectedObject = null;
    }
}