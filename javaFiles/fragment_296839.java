public class BackendContainer implements IModelFactory {

    private ShopOrderRepository shopOrderRepository;

    public BackendController getBackendController()
    {
        return new BackendController(null);
    }

    /**
     * Instantiates a singleton ShopOrderRepository instance per BackendContainer instance
     * @return ShopOrderRepository
     */
    public ShopOrderRepository getShopOrderRepository() {

        if(shopOrderRepository == null) {
            synchronized(ShopOrderRepository.class) {
                if (shopOrderRepository == null) {
                    shopOrderRepository = new ShopOrderRepository(this);
                }
            }
        }

        return shopOrderRepository;
    }
}