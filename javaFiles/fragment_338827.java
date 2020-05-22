tp.addChangeListener(new ChangeListener() {
    @Override
    public void stateChanged(ChangeEvent e) {
        Component selectedComponent = tp.getSelectedComponent();
        if (selectedComponent instanceof Loadable) {
            ((Loadable)selectedComponent).load();
        }
    }
}