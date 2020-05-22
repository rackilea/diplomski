public class MyAdapter ... {
    private static final int COMPLETE_TYPE_INDEX = 0;
    private static final int INPROCESS_TYPE_INDEX = 1;
    private static final int NUMBER_OF_LAYOUTS = 2;

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            if(getItemViewType(position) == COMPLETE_TYPE_INDEX)
                convertView = mInflater.inflate(R.layout.listview_item_product_complete, null);
            else // must be INPROCESS_TYPE_INDEX
                convertView = mInflater.inflate(R.layout.listview_item_product_inprocess, null);

            // etc, etc...
            // Depending on what is different in your layouts, 
            //   you may need update your ViewHolder and more of getView()
        }

        // Load data that changes on each row, might need to check index type here too
    }
    @Override
    public int getItemViewType(int position) {
        Order thisOrder = (Order) myOrders.getOrderList().get(position);

        if(thisOrder.getOrderStatus().equals("Complete")) return COMPLETE_TYPE_INDEX;
        else return INCOMPLETE_TYPE_INDEX;
    }
    @Override
    public int getViewTypeCount() {
        return NUMBER_OF_LAYOUTS;
    }
}