public class CustomResponse {
    private int id;
    @io.swagger.annotations.ApiModelProperty(value = "my super product name")
    private String productName;
    @io.swagger.annotations.ApiModelProperty(allowableValues = "1,5,10,25,50")
    private int quantity;
    private double price;

    // Constructor & along with Getters & Setters

}