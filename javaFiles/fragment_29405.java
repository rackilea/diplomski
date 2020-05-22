@Title("Backoffice for SO Question #42927030")
public class MainUI extends UI {

    private Cookie login(URI targetUri, String loginPath, Map<String, String> params) throws IOException {
        // ...
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(new VerticalLayout(new Button("Log into site...", event -> {

            try {
                URI targetUri = new URI("http://localhost:8080");

                Map<String, String> params = new HashMap<>();
                params.put("username", "Johnny");
                params.put("password", "incorrect :)");
                // Eventual hidden fields, etc.
                // params.put("...", "...");

                Cookie targetAuthCookie = login(targetUri, "/log-me-in", params);

                // We're not ready just yet: we still need to 'transfer' the cookie
                // the HTTP client received to the current browser:
                VaadinService.getCurrentResponse().addCookie(targetAuthCookie);

                // Upon responding to the Vaadin 'click' request, open the target URL (eventually in a new page / tab):
                Page.getCurrent().getJavaScript().execute("window.open('" + targetUri + "');");

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        })));
    }

    @WebServlet(urlPatterns = "/*", name = "MainUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MainUI.class, productionMode = false)
    public static class MainUIServlet extends VaadinServlet {}
}