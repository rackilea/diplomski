MyUi extends UI{
    // the rest of the initialization....
    @Override
    protected void init(VaadinRequest request) {
        MyUiContent myUi = new MyUiContent();
        setContent(myUi.init());
        setNavigator(new Navigator(this, myUi);
    }
}