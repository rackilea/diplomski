private class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    private List<ProductModel> list;

    ProductAdapter(List<ProductModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int position) {
        String productName = list.get(position).getProductName();
        productViewHolder.setProductName(productName);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}