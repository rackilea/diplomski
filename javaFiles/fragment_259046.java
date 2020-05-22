@DynamoDBTable(tableName = "Items")
public class Item {

    private String product;
    private Integer id;

    @DynamoDBHashKey(attributeName = "Product")
    public String getProduct() {
        return autoID;
    }   
    @DynamoDBRangeKey(attributeName = "ID")
    public String getId() {
        return id;
    }           
}