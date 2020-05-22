public void addGood(Good good) {
    good.setShoppingCart(this);
    this.getGoods().add(good);
}
public Good removeGood(Good good) {
    this.getGoods().remove(good);
    good.setShoppingCart(null);
    return good;
}