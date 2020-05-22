@EmbeddedId
 private OrderLinePk pk;

 @MapsId("orderId")
 @ManyToOne
 private Order order;