public class StartPage extends WebPage {
    public StartPage(final PageParameters parameters) {     

            Form<?> form = new Form<Void>("form") {
                @Override
                protected void onSubmit() {
                    // Delete from DB
                    // Load from web to DB
                    // Load from DB     
                }
            };

            if (parameters.getString("flag")!=null)
                // Load from DB
    }
}