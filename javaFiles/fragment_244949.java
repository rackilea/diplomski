public void setShops(List<Shop> shops) {
    this.shops = shops;
    if (this.shopsDefault == null) {
        this.shopsDefault = new ArrayList<>(shops);
    }
}