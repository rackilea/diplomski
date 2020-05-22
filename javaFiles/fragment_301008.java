public void searchByFirstValue(String search)
  {
    if(search == null || search.length() == 0)
      return;

    for(Order order : orderList)
    {
      if(order.getFirstValue().contains(search)) //java.lang.String methods via a regular expression
        setSelectedOrder(order);

      return;
    }
  }