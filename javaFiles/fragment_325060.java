// Observe product data
model.getObservableProduct().observe(this, new Observer<ProductEntity>() {
    @Override
    public void onChanged(@Nullable ProductEntity productEntity) {
        model.setProduct(productEntity);
    }
});