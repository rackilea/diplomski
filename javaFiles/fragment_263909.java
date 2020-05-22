@Component   
public class CartMapper extends ConfigurableMapper {

    @Override
    public void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(BillingSummary.class, BillingSummary.class).exclude("billableItems").byDefault().register();
        mapperFactory.classMap(Cart.class,FilteredCart.class).byDefault().register();
    }
}