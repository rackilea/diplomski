public CreateTabs ResetFrame(){
    this.dispose()
    CreateTabs newTabs = new CreateTabs();
    newTabs.setVisible(true);
    return newTabs;
}
...
if(!createTabs.isVisible()){
    createTabs = createTabs.ResetFrame();
    createTabs.setVisible(true);
}