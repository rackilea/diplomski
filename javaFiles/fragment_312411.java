@Override
public void start(Stage primaryStage) {

    StackPane root = new StackPane();

    /* example Treeview */
    TreeView<Item> tw = new TreeView<>();
    CheckBoxTreeItem<Item> rootNode = new CheckBoxTreeItem<>(new Item("Root"));
    CheckBoxTreeItem<Item> blockOne = new CheckBoxTreeItem<>(new Item("Block1"));
    CheckBoxTreeItem<Item> childA = new CheckBoxTreeItem<>(new Item("ChildA"));
    CheckBoxTreeItem<Item> childB = new CheckBoxTreeItem<>(new Item("ChildB"));
    blockOne.getChildren().add(childA);
    blockOne.getChildren().add(childB);
    CheckBoxTreeItem<Item> blockTwo = new CheckBoxTreeItem<>(new Item("Block2"));
    CheckBoxTreeItem<Item> childC = new CheckBoxTreeItem<>(new Item("ChildC"));
    CheckBoxTreeItem<Item> childD = new CheckBoxTreeItem<>(new Item("ChildD"));
    blockTwo.getChildren().add(childC);
    blockTwo.getChildren().add(childD);
    rootNode.getChildren().add(blockOne);
    rootNode.getChildren().add(blockTwo);
    tw.setRoot(rootNode);

    StringConverter<TreeItem<Item>> itemStringConverter = new StringConverter<TreeItem<Item>>() {

        @Override
        public String toString(TreeItem<Item> item) {
            return item.getValue().getName();
        }

        @Override
        public TreeItem<Item> fromString(String string) {
            return new TreeItem<>(new Item(string));
        }

    };

    /* add CheckBoxes */
    tw.setCellFactory(
            CheckBoxTreeCell.forTreeView(treeItem -> treeItem.getValue().selectedProperty(), itemStringConverter));

    root.getChildren().add(tw);
    Scene scene = new Scene(root, 300, 250);
    primaryStage.setTitle("Hello World!");
    primaryStage.setScene(scene);
    primaryStage.show();
}

public static class Item {

    private final String name;
    // use something with a more meaningful name here:
    private final BooleanProperty selected = new SimpleBooleanProperty();

    public Item(String name, boolean selected) {
        this.name = name;
        setSelected(selected);
    }

    public Item(String name) {
        this(name, false);
    }

    public String getName() {
        return name;
    }

    public BooleanProperty selectedProperty() {
        return selected;
    }

    public final boolean isSelected() {
        return selectedProperty().get();
    }

    public final void setSelected(boolean selected) {
        selectedProperty().set(selected);
    }
}