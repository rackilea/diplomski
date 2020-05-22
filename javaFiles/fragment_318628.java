public class HomePage extends WebPage {
    public HomePage(PageParameters pageParameters) {
        super(pageParameters);

        ModalWindow modal = new ModalWindow("modal");
        modal.add(new OpenWindowOnLoadBehavior());
        modal.setPageCreator(new ModalWindow.PageCreator() {
            @Override
            public Page createPage() {
                return new RedirectPage("http://www.google.com");
            }
        });
        add(modal);
    }
}