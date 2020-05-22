private void scanInputControls(Pane parent) {
    for (Node component : parent.getChildren()) {
        if (component instanceof Pane) {
            //if the component is a container, scan its children
            scanInputControls((Pane) component);
        } else if (component instanceof IInputControl) {
            //if the component is an instance of IInputControl, add to list
            lstInputControl.add((IInputControl) component);
        }
    }
}