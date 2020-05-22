public boolean setFocus () {
    checkWidget ();
    Control [] children = _getChildren ();
    for (int i= 0; i < children.length; i++) {
        if (children [i].setFocus ()) return true;
    }
    return super.setFocus ();
}