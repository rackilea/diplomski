public class IdAndNameStringProvider implements ValueProvider<Stock, String> {
    public String getValue(Stock object) {
        return object.getId() + "-" + object.getName();
    }
    //...
}