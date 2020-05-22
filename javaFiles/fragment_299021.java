cartViewHolder.removeItem.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, listData.size());
        Order order = listData.get(i);
        new Database(cartActivity).clearItem(order);
        listData.remove(i);
        calculate();
    }
});