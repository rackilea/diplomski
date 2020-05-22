public class OrderItemDetailsDTO {

    @XmlElement
    @Min(1)
    private long orderItemId;

    // getters and setters...
 }

@Path("orders")
public class OrdersResource {
  @POST
  @Consumes({ "application/xml" })
  public void place(@Valid OrderItemDetailsDTO order) {
    // Jersey recognizes the @Valid annotation and
    // returns 400 when the JavaBean is not valid
  }
}