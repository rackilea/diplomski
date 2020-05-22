//Field to store current component
private reprintsTab currentComponent; 

//during initialization
currentComponent = new reprintsTab();
sheet.addTab(currentComponent);

sheet.addListener(new TabSheet.SelectedTabChangeListener() {
    @Override
    public void selectedTabChange(SelectedTabChangeEvent event) {
        reprintsTab newComponent = new reprintsTab();
        sheet.replaceComponent(currentComponent, newComponent);
        currentComponent = newComponent;
    }
});