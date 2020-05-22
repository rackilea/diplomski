@Value
public class Order implements Serializable {

  private static final long serialVersionUID = 901109456762331944L;

  OrderKey key;

  String description;

  String amount;

  Operation operation;

  LocalDateTime creationDate;

  @Value
  public static class Operation {

    String id;

    String description;

    String status;

    LocalDateTime creationDate;
  }

}


@Value
public class OrderKey implements Serializable {

  private static final long serialVersionUID = -8102116676316181864L;

  private String orderId;

  public static OrderKey get( String orderId ) {
      return new OrderKey( orderId );
  }

}