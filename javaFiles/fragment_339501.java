public class HomePage extends WebPage {
    public HomePage() {
        Component field1 = new TextField("field1").setOutputMarkupId(true);
        Component field2 = new TextField("field2").setOutputMarkupId(true);
        Component hidden = new HiddenField("hidden").setOutputMarkupId(true);

        String script = String.format("concatValues('%s','%s','%s');",
                field1.getMarkupId(), field2.getMarkupId(), hidden.getMarkupId());
        Component concat = new Button("concat").add(new SimpleAttributeModifier("onclick", script));

        Component show = new Button("show").add(new SimpleAttributeModifier("onclick",
            String.format("alert(document.getElementById('%s').value);", hidden.getMarkupId())));

        add(new Form("form").add(field1, field2, hidden, concat, show));
    }
}