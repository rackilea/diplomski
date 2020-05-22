public Control findControlById(Integer id) {
    Shell[] shells = Display.getCurrent().getShells();

    for(Shell e : shells) {
        Control foundControl = findControl(e, id);
        if(foundControl != null) {
            return foundControl;
        }
    }
    return null;
}

private Control findControl(Composite c, Integer id) {
    Control[] children = c.getChildren();
    for(Control e : children) {
        if(e instanceof Composite) {
            Control found = findControl((Composite) e, id);
            if(found != null) {
                return found;
            }
        } else {
            int value = id.intValue();
            int objValue = ((Integer)e.getData()).intValue();

            if(value == objValue)
                return e;
        }
    }
    return null;
}