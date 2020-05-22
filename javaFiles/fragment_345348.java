public class Item {
    private int amount;
    private double price;
    private final String name;
    private final String type;
    private final String madeIn;
    private static Set<String> registeredNames = new HashSet<String>();
    Item(int amount, double price, String name, String type, String madeIn)
    {
        registeredNames.add (name); // you should consider what you want to do
                                    // if the same name is passed to two instances
                                    // perhaps throw an exception  
        this.amount=amount;
        this.madeIn=madeIn;
        this.name=name;
        this.type=type;
        this.price=price;
    }
}