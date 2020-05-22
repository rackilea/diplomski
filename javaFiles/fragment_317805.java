MyUiContent implements ViewDisplay { 
    private HorizontalLayout mainViewLayout;

    public Component init() {
        this.mainViewLayout = new HorizontalLayout();
        return this.mainViewLayout;
    }
    @Override
    public void showView(View view) {
        //handle view display
        mainViewLayout.removeAllComponents();
        mainViewLayout.addComponent(view);
    }
}