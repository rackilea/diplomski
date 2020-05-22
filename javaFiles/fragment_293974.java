public class HomePage extends WebPage {

    public HomePage() {

        add(new Label("label", "<ul><li>test</li><li>test</li><li>test</li><li>test</li><li>test</li></ul>")
            .setEscapeModelStrings(false));

        add(new WebComponent("html") {
            @Override
            protected void onComponentTagBody(MarkupStream markupStream, ComponentTag openTag) {
                Response response = getRequestCycle().getResponse();
                response.write("<ul>");
                for (int i = 0; i < 5; i++)
                    response.write("<li>test</li>");
                response.write("</ul>");
            }
        });
    }
}