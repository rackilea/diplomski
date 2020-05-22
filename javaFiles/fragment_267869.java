public class NestedTableView extends VBox {
    private ObservableList<Node> titledPanes = FXCollections.observableArrayList();
    private Region parent;

    public NestedTableView(Region parent, ObservableList<ProductBundle> bundlesToDisplay){
        this.parent = parent;
        VBox nestedView = new VBox();
        Bindings.bindContentBidirectional(nestedView.getChildren(), titledPanes);
        titledPanes.addAll(bundlesToDisplay.stream()
                .map(TablePane::new).collect(Collectors.toList()));
        getChildren().setAll(createHeader(), nestedView);
        getStylesheets().add("CSS/nestedTableViewStyles.css");
    }

    private HBox createHeader(){
        //Set up widths to align with the content headers beneath the header
        Label symbol = new Label("#");
        symbol.setPrefWidth(25); //Sum of the values used by the "arrow" region

        Label productId = new Label("Product Id");
        productId.prefWidthProperty().bind(parent.widthProperty().multiply(0.15));

        Label productName = new Label("Product Name");
        productName.prefWidthProperty().bind(parent.widthProperty().multiply(0.35)); //Give name extra space

        Label amount = new Label("Amount");
        amount.prefWidthProperty().bind(parent.widthProperty().multiply(0.15));

        Label date = new Label("Order Date");
        date.prefWidthProperty().bind(parent.widthProperty().multiply(0.15));

        Label quantityAvailable = new Label("#Available");
        quantityAvailable.prefWidthProperty().bind(parent.widthProperty().multiply(0.15));

        HBox header = new HBox(symbol, productId, productName, amount, date, quantityAvailable);
        header.getStyleClass().add("header");
        return header;
    }

    private class TablePane extends TitledPane {
        private ProductBundle productBundle;

        private HBox header;
        private TableView contentTableView;
        private MenuItem addToBundle, deleteBundle;

        public TablePane(ProductBundle productBundle){
            this.productBundle = productBundle;
            setupMenuItems();
            setupContentHeader();
            setGraphic(header);
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            if(!productBundle.getBundleItems().isEmpty()){
                createTableView();
                setContent(contentTableView);
            }

            //Only display the expandable "arrow" if there is content to display
            collapsibleProperty().bind(contentProperty().isNotNull());
            //If the "arrow" isn't displayed, pad the area to mimic the arrow being present to align headers
            header.paddingProperty().bind(
                    Bindings.when(collapsibleProperty()).then(Insets.EMPTY).otherwise(new Insets(0,0,0,15)));
            /*  For testing purposes. With more rows this will clutter the UI
                ToDo: add logic to determine how many panes to expand before the viewport has been filled
             */
            setExpanded(true);
        }

        private void setupMenuItems(){
            addToBundle = new MenuItem("Add to bundle");
            addToBundle.setOnAction(event -> {
                //ToDo: Add CRUD create logic here
                System.out.println("Add to bundle: " + productBundle.idProperty());
            });
            deleteBundle = new MenuItem("Delete bundle");
            deleteBundle.setOnAction(event -> {
                //ToDo: Add CRUD delete logic here
                System.out.println("Delete bundle: " + productBundle.idProperty());
            });
        }

        private void setupContentHeader(){
            header = new HBox();
            //Bind the content header to the root so that it aligned with the initial header
            header.prefWidthProperty().bind(parent.widthProperty());
            header.maxWidthProperty().bind(parent.widthProperty());

            /* Set up each TextField with widths to align with the TableView
               Each TextField is editable with the exception of id as it would be the primary key
               and amount as it's value is calculated from the sub items */
            TextField id = new TextField();
            id.setEditable(false);
            modifyTextFieldContextMenu(id);
            id.textProperty().bind(productBundle.idProperty());
            id.prefWidthProperty().bind(header.widthProperty().multiply(0.15));

            TextField name = new TextField();
            modifyTextFieldForCRUDFunctionality(name);
            name.textProperty().bindBidirectional(productBundle.nameProperty());
            name.prefWidthProperty().bind(header.widthProperty().multiply(0.35)); //Give name extra space

            TextField amount = new TextField();
            amount.setEditable(false);
            Bindings.bindBidirectional(amount.textProperty(), productBundle.amountProperty(),
                    new NumberStringConverter(NumberFormat.getCurrencyInstance(Locale.US)));
            amount.prefWidthProperty().bind(header.widthProperty().multiply(0.15));

            TextField date = new TextField();
            modifyTextFieldForCRUDFunctionality(date);
            date.textProperty().bind(productBundle.orderDateProperty());
            date.prefWidthProperty().bind(header.widthProperty().multiply(0.15));

            TextField quantityRemaining = new TextField();
            modifyTextFieldForCRUDFunctionality(quantityRemaining);
            //Only display a quantity if it's a valid value (to match example screen shot)
            quantityRemaining.textProperty().bind(
                    Bindings.when(productBundle.quantityAvailableProperty().greaterThan(0))
                            .then(productBundle.quantityAvailableProperty().asString()).otherwise("N/A"));
            quantityRemaining.prefWidthProperty().bind(header.widthProperty().multiply(0.15));

            header.getChildren().setAll(id, name, amount, date, quantityRemaining);
            header.getStyleClass().add("content-header");
        }

        private void modifyTextFieldContextMenu(TextField textField){
            TextFieldSkin skin = new TextFieldSkin(textField){
                @Override
                public void populateContextMenu(ContextMenu contextMenu) {
                    super.populateContextMenu(contextMenu);
                    contextMenu.getItems().add(0, addToBundle);
                    contextMenu.getItems().add(1, deleteBundle);
                    contextMenu.getItems().add(2, new SeparatorMenuItem());
                }
            };
            textField.setSkin(skin);
        }

        private void modifyTextFieldForCRUDFunctionality(TextField textField){
            textField.setEditable(true);
            textField.focusedProperty().addListener(new ChangeListener<Boolean>() {
                private String previousText;
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    String currentText = textField.getText();
                    if(newValue){
                        previousText = currentText;
                    }
                    //ToDo: Add CRUD update logic here
                    else if(!previousText.equals(currentText)){
                        System.out.println("Value has been changed from: " + previousText + " to: " + currentText);
                    }
                }
            });
        }

        private void createTableView(){
            TableColumn<BundleItem, String> idColumn = new TableColumn<>("#ID");
            idColumn.setCellValueFactory(param -> param.getValue().getItem().itemIdProperty());

            TableColumn<BundleItem, String> nameColumn = new TableColumn<>("Item");
            nameColumn.setCellValueFactory(param -> param.getValue().getItem().itemNameProperty());

            TableColumn<BundleItem, String> amountColumn = new TableColumn<>("Amount");
            amountColumn.setCellValueFactory(param -> param.getValue().getItem().amountProperty().asString("$%.2f"));

            TableColumn<BundleItem, Number> quantityColumn = new TableColumn<>("Qty");
            quantityColumn.setCellValueFactory(param -> param.getValue().quantityProperty());

            TableView<BundleItem> tableView = new TableView<>(productBundle.getBundleItems());
            tableView.setPadding(new Insets(10));
            //Equal column widths
            tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            tableView.getColumns().setAll(idColumn, nameColumn, amountColumn, quantityColumn);
            //Only show visible shows
            tableView.setFixedCellSize(30);
            tableView.prefHeightProperty().bind(Bindings.size(productBundle.getBundleItems())
                    .multiply(tableView.getFixedCellSize()).add(tableView.getFixedCellSize()*1.5));
            contentTableView = tableView;
        }
    }
}