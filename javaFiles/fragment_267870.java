public class ProductBundle {
    private ObservableList<BundleItem> bundleItems = FXCollections.observableArrayList();
    private SimpleStringProperty productId, productName, orderDate;
    private SimpleDoubleProperty amount = new SimpleDoubleProperty();
    private SimpleIntegerProperty quantityAvailable;

    private ProductBundle(String productId, String productName, String orderDate, int quantityAvailable){
        this.productId = new SimpleStringProperty(productId);
        this.productName = new SimpleStringProperty(productName);
        this.orderDate = new SimpleStringProperty(orderDate);
        this.quantityAvailable = new SimpleIntegerProperty(quantityAvailable);
    }

    public ProductBundle(String productId, String productName, String orderDate,
                         int quantityAvailable, ObservableList<BundleItem> bundleItems){
        this(productId, productName, orderDate, quantityAvailable);
        //Setup an extractor to "Observe" changes on the amount/quantity of any items in the bundle
        this.bundleItems = FXCollections.observableArrayList(new Callback<BundleItem, Observable[]>() {
            @Override
            public Observable[] call(BundleItem param) {
                return new Observable[]{param.amountProperty(), param.quantityProperty()};
            }
        });
        this.bundleItems.addAll(bundleItems);
        //Calculate the total worth of this bundle
        amount.bind(Bindings.createDoubleBinding(()->
                bundleItems.stream().collect(Collectors.summingDouble(BundleItem::getAmount)), this.bundleItems)
                .multiply(quantityAvailable));
    }

    public ProductBundle(String productId, String productName, String orderDate,
                         int quantityAvailable, double amount){
        this(productId, productName, orderDate, quantityAvailable);
        this.amount.set(amount);
    }

    public ObservableList<BundleItem> getBundleItems(){
        return bundleItems;
    }

    public SimpleStringProperty idProperty(){
        return productId;
    }

    public SimpleStringProperty nameProperty(){
        return productName;
    }

    public SimpleIntegerProperty quantityAvailableProperty(){
        return quantityAvailable;
    }

    public SimpleStringProperty orderDateProperty(){
        return orderDate;
    }

    public SimpleDoubleProperty amountProperty(){
        return amount;
    }

    public double getAmount(){
        return amount.get();
    }
}

public class BundleItem {
    private Item item;
    private SimpleIntegerProperty quantity;
    private SimpleDoubleProperty amount = new SimpleDoubleProperty();

    public BundleItem(Item item, int quantity){
        this.item = item;
        this.quantity = new SimpleIntegerProperty(quantity);
        amount.bind(item.amountProperty().multiply(quantity));
    }

    public Item getItem(){
        return item;
    }

    public SimpleIntegerProperty quantityProperty(){
        return quantity;
    }

    public SimpleDoubleProperty amountProperty(){
        return amount;
    }

    public double getAmount(){
        return amount.get();
    }
}

public class Item {
    private SimpleStringProperty itemId, itemName;
    private SimpleDoubleProperty amount;

    public Item(String itemId, String itemName, double amount){
        this.itemId = new SimpleStringProperty(itemId);
        this.itemName = new SimpleStringProperty(itemName);
        this.amount = new SimpleDoubleProperty(amount);
    }

    public SimpleStringProperty itemIdProperty(){
        return itemId;
    }

    public SimpleStringProperty itemNameProperty(){
        return itemName;
    }

    public SimpleDoubleProperty amountProperty(){
        return amount;
    }

    public double getAmount(){
        return amount.get();
    }

    public void setAmount(double newValue){
        amount.set(newValue);
    }
}