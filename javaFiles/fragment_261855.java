@Getter @Setter
public class WarehouseResponse {
// Change the list to warehouse object as it is in response
//      private List<WarehouseField> warehouse; 
    private Warehouse warehouse;
    private String url;
    private Date date = new Date();

}