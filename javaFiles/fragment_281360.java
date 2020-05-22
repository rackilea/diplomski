String menuTabSelected =(String)VaadinSession.getCurrent().getAttribute("menuState");
MenuBar barmenu = new MenuBar();
barmenu.addStyleName("mybarmenu");
layout.addComponent(barmenu);

String homepageStyle = menuTabSelected == null || menuTabSelected.equals(StringConstants.MENU_HOMEPAGE_LABEL) ? "highlight" : null;

barmenu.addItem(StringConstants.MENU_HOMEPAGE_LABEL, VaadinIcons.HOME, createCommandHomepage()).setStyleName(homepageStyle);


private Command createCommandHomepage() {
    return new Command() {
        @Override
        public void menuSelected(final MenuItem selectedItem) {

            VaadinSession.getCurrent().setAttribute("menuState", selectedItem.getText());

            UI.getCurrent().getNavigator().navigateTo(StringConstants.HOMEPAGE_VIEW_NAME);
        }
    };
}