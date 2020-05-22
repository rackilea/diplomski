adapter = new FirestoreRecyclerAdapter<ProductModel, ProductViewHolder>(options) {
    @Override
    protected void onBindViewHolder(@NonNull holder productViewHolder, int position, @NonNull ProductModel productModel) {
        holder.setProductName(productModel.getProductName());
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }
};
recyclerView.setAdapter(adapter);