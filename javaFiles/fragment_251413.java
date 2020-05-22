@Override
public void init() {
    addViewFactory(HOME_VIEW, LoginPage::new);
    addViewFactory("MainView", MainView::new);
    ...
}