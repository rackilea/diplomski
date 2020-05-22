public class NestedTableViewExample extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ObservableList<ProductBundle> bundles =
                FXCollections.observableArrayList(
                        new ProductBundle("1001456", "Spring Season Gift", "02/14/2015", 1,
                                FXCollections.observableArrayList(
                                        new BundleItem(new Item("17890", "PS 3", 150.00), 1),
                                        new BundleItem(new Item("17891", "Heart shape ring", 100.00), 1)
                                )),
                        new ProductBundle("1001457", "Christmas Season Gift", "04/14/2015", 1,
                                FXCollections.observableArrayList(
                                        new BundleItem(new Item("17900", "Chocolate Giftbox", 150.00), 1),
                                        new BundleItem(new Item("17901", "Xbox 360", 199.00), 1)
                                )),
                        new ProductBundle("1001458", "Birthday Gift", "", 1, 200)
                );

        VBox root = new VBox();
        root.getChildren().setAll(new NestedTableView(root, bundles));
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Nested TableView example");
        primaryStage.show();
    }
}