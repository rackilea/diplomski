SwingViewBuilder factory = new SwingViewBuilder(controller, properties){
    @Override
    public JToolBar buildPageNavigationToolBar() {
        JToolBar toolbar = new JToolBar();
        commonToolBarSetup(toolbar, false);
        addToToolBar(toolbar, buildPreviousPageButton());
        addToToolBar(toolbar, buildCurrentPageNumberTextField());
        addToToolBar(toolbar, buildNumberOfPagesLabel());
        addToToolBar(toolbar, buildNextPageButton());
        return toolbar;
    }
};