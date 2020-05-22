private class ProductViewHolder extends RecyclerView.ViewHolder {
    private View view;

    ProductViewHolder(View itemView) {
        super(itemView);
        view = itemView;
    }

    void setProductName(String productName) {
        TextView textView = view.findViewById(R.id.text_view);
        textView.setText(productName);
    }
}