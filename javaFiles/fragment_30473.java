public abstract class EnumPriceType {

    public static final EnumPriceType WITH_TAXES = new EnumPriceType() {
        //getPrice() {...}
        //getFormattedPrice() {...}
    };

    public static final EnumPriceType WITHOUT_TAXES = new EnumPriceType() {
        //getPrice() {...}
    };

    public abstract float getPrice(float input);

    public static void main(String[] args) {
        WITH_TAXES.getFormattedPrice(33f);
    }
}