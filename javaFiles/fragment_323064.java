public class SalesManagementService implements SalesManagementServiceInterface {

    private DatabaseReadSalesInterface dbRead;
    private DatabaseWriteSalesInterface dbWrite;
    private WarehouseManagementServiceInterface warehouseManagementService;

    constructor(DatabaseReadSalesInterface dbRead,
                DatabaseWriteSalesInterface dbWrite,
                WarehouseManagementServiceInterface warehouseManagementService) {
        this.dbRead = dbRead;
        this.dbWrite = dbWrite;
        this.warehouseManagementService = warehouseManagementService;
    }

    public void addOrder(Order o) {
    // creates order, if product quantity is sufficient
    }

}