public class EditPage extends WebPage {
    public EditPage(final PageParameters parameters) {
        Form<?> form = new Form<Void>("form") {
                    @Override
                    protected void onSubmit() {
                        // if button "save" clicked
                        PageParameters params = new PageParameters();
                        params.add("flag", "true");
                        setResponsePage(StartPage.class, params);
                    }
        };
    }
}