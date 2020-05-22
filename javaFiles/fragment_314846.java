Button go = new Button("Go");

EventHandler<ActionEvent> goAction = new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent arg0) {
        browser.load(location.getText(), new Runnable() {
            @Override
            public void run() {
                System.out.println("---------------");
                System.out.println(browser.getHTML());
            }
        });
    }
};

...

MenuItem menuItem = new MenuItem("Go!");
menuItem.setAccelerator(new KeyCodeCombination(KeyCode.G, KeyCombination.CONTROL_DOWN));

go.setOnAction(goAction);
menuItem.setOnAction(goAction);