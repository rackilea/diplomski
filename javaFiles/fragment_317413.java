public class Pizza extends GenericDataInterface<Pizza.PizzaAttributes> {
    public enum PizzaAttributes { NAME, TOPPINGS, PRICE };

    private String name;
    private Set<String> toppings;
    // WARNING: Do not use Float for prices in real applications!
    private float price;

    @Override
    public Object getData(PizzaAttributes key) {
        switch (key) {
            case NAME:
                return name;
            case TOPPINGS:
                return toppings;
            case PRICE:
                return price;
            default:
                throw new IllegalArgumentException(
                        "Key " + key + " isn't defined for " + Pizza.class.getCanonicalName());
        }
    }
}