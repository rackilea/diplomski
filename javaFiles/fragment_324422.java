public class Subscription {
    private List<DiscountData> data = new ArrayList<DiscountData>();

    public void addDiscount(DiscountData discountData) {
       data.add(discountData);
    }
}