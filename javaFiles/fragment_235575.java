public void AddProduct(final Product product){
new Thread(new Runnable() {
    @Override
    public void run() {
        db.inventory().insertOneProduct(product);
    }
});
 }