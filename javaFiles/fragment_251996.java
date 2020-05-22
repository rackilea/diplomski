public class HomePage extends MasterPage {
    public HomePage() {
        add(new TextField<String>("textField1", new Model<String>("Text Field 1")).add(newOnClickBehavior()));
        add(new TextField<String>("textField2", new Model<String>("Text Field 2")).add(newOnClickBehavior()));       
    }

    protected AjaxEventBehavior newOnClickBehavior() {
        return new AjaxEventBehavior("onClick") {
            private static final long serialVersionUID = 1L;

            @Override
            protected void onEvent(AjaxRequestTarget target) {
                // Same behavior of both the textField1 and textField2
            }
        };
    }
}