private static Node[] fromStrings(ToggleGroup group, String... strings) {
    Node[] result = new Node[strings.length];

    for (int i = 0; i < strings.length; i++) {
        ToggleButton button = new ToggleButton(strings[i]);
        button.setPrefSize(100, 50);
        button.setTextAlignment(TextAlignment.CENTER);
        button.setToggleGroup(group);
        result[i] = button;
    }

    return result;
}

@Override
public void start(Stage primaryStage) {
    GridPane root = new GridPane();
    final ToggleGroup group = new ToggleGroup();
    root.addRow(0, fromStrings(group, "If", "VVS1", "VVS2", "VS1", "VS2", "SI1", "SI2", "SI2-", "SI3", "SI3-"));
    root.addRow(1, fromStrings(group, "I1", "I1-", "I2", "I2-", "I3", "I4", "I5", "I6", "I7", "I8"));

    root.setFocusTraversable(true);
    root.setOnKeyTyped(new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent event) {
            String s = event.getCharacter().toUpperCase();
            // move focus to the next matching element
            if (s.length() == 1) {
                event.consume();
                List<Toggle> toggles = group.getToggles();
                int selectedIndex = toggles.indexOf(group.getSelectedToggle());
                int size = toggles.size();

                // search next matching node starting directly after the
                // selected position
                for (int i = selectedIndex + 1; i < size; i++) {
                    Toggle l = toggles.get(i);
                    if (((Labeled)l).getText().toUpperCase().startsWith(s)) {
                        group.selectToggle(l);
                        return;
                    }
                }
                for (int i = 0; i < selectedIndex; i++) {
                    Toggle l = toggles.get(i);
                    if (((Labeled)l).getText().toUpperCase().startsWith(s)) {
                        group.selectToggle(l);
                        return;
                    }
                }
            }
        }
    });

    Scene scene = new Scene(root);
    root.requestFocus();

    primaryStage.setScene(scene);
    primaryStage.show();
}