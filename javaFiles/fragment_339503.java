public class HomePage extends WebPage {
    String field1;
    String field2;
    String hidden;
    public HomePage() {
        Form form = new Form("form", new CompoundPropertyModel(this));
        form.add(new TextField("field1"));
        form.add(new TextField("field2"));
        form.add(new HiddenField("hidden"));
        form.add(new AjaxButton("concat") {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                hidden = field1 + field2;
                target.addComponent(form);
            }
        });
        form.add(new AjaxButton("show") {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                target.appendJavascript("alert('" + JavascriptUtils.escapeQuotes(hidden) + "')");
            }
        });
        add(form);
    }
}