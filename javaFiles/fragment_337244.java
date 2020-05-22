public class PizzaOrder {
    public static final String PIZZA_SMALL = "S";
    public static final String PIZZA_MEDIUM = "M";
    public static final String PIZZA_LARGE = "L";
    public static final String PIZZA_COLLOSAL = "C";

    public static final double SMALL_DIAMETER = 9;
    public static final double MEDIUM_DIAMETER = 13;
    public static final double LARGE_DIAMETER = 17;
    public static final double COLOSSAL_DIAMETER = 26;

    public static final double PRICE_SMALL = 8;
    public static final double PRICE_MEDIUM = 11;
    public static final double PRICE_LARGE = 15;
    public static final double PRICE_COLOSSAL = 21;
    public static final double PRICE_TAX = 0.095;
    public static final double PRICE_TOPPING = 0.99;

    public static final int MAX_TOPPINGS = 8;
    public static final int MIN_TOPPINGS = 0;

    /**
     * Pizza Order
     *
     * @param args
     *            command-line arguments
     */

    public static double getDiameter(String pizzaName) {
        if (pizzaName.equals(PIZZA_SMALL)) {
            return SMALL_DIAMETER;
        } else if (pizzaName.equals(PIZZA_MEDIUM)) {
            return MEDIUM_DIAMETER;
        } else if (pizzaName.equals(PIZZA_LARGE)) {
            return LARGE_DIAMETER;
        } else {
            return COLOSSAL_DIAMETER;
        }
    }

    public static double getBasePrice(String pizzaName) {
        if (pizzaName.equals(PIZZA_SMALL)) {
            return PRICE_SMALL;
        } else if (pizzaName.equals(PIZZA_MEDIUM)) {
            return PRICE_MEDIUM;
        } else if (pizzaName.equals(PIZZA_LARGE)) {
            return PRICE_LARGE;
        } else {
            return PRICE_COLOSSAL;
        }
    }
}