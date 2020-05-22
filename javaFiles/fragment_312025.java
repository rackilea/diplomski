private void NotifyDataChangedOrderListSorted(String sort){
    orderList.clear(); // Change this
    mySQLiteAdapter = new SQLiteAdapter(context);
    mySQLiteAdapter.openToRead();

    ...
    cursor.close();
    mySQLiteAdapter.close();
    orderAdapter.notifyDataSetChanged(); // Change this

}