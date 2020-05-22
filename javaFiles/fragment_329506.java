when
  $orderstatus : OrderStatus(...)
then
  modify ($orderstatus) {
     valid = Boolean.TRUE
  }