public class MyListSelectComponent extends VerticalLayout {

    public MyListSelectComponent() {
        ListSelect list = new ListSelect("Press DEL to remove items");
        TextField input = new TextField("Focus this input and press DEL to delete some text");
        input.setValue("This is some very long text, or not...");

        for (int i = 0; i < 10; i++) {
            list.addItem(i);
        }

        Panel panel = new Panel(list);
        panel.addShortcutListener(new ShortcutListener("", ShortcutAction.KeyCode.DELETE, null) {
            @Override
            public void handleAction(Object sender, Object target) {
                if (list.getValue() != null) {
                    list.removeItem(list.getValue());
                }
            }
        });

        addComponent(panel);
        addComponent(input);
    }
}