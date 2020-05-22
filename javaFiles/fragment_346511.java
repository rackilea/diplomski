@Component
public class PaymentPlanMapper {

    private PaymentPlanMapper()  {
        ShopifyBaseMapper.factory.classMap(PaymentPlan.class, ShopifyRecurringApplicationCharge.class)
        .field("shopifyID","id")
        .byDefault()
        .register();
    }

}