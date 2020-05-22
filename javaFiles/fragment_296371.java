public static class ProductItemViewHolder extends RecyclerView.ViewHolder {

    private TextView mProductName;

    private Button mRemoveButton;

    private OnItemRemovedListener mListener;

    public ProductItemViewHolder(View itemView) {
        super(itemView);
        mProductName = (TextView) itemView.findViewById(R.id.product_name);
        mRemoveButton = (Button) itemView.findViewById(R.id.remove_button);
    }

    public void bind(Model data, OnItemRemovedListener listener) {

        mProductName.setText(data.getProductName());
        mListener = listener;
        mRemoveButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                int position = getAdapterPosition();
                if (position >= 0) {
                    mListener.itemRemoved(position);
                }
            }
        });
    }
}