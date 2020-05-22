if (myOrderItemModelList.stream().anyMatch(item -> "Delivered".equals(item.status()))) {
      MyOrderItemOnProcessAdapter myOrderItemOnProcessAdapter = new 
      MyOrderItemOnProcessAdapter(myOrderItemModelList);
      my_orders_recyclerview.setAdapter(myOrderItemOnProcessAdapter);
      myOrderItemOnProcessAdapter.notifyDataSetChanged();           
}