public void addGood(Good good) {
    good.setShoppingCart(this);
    goods.add(good);
}
public Good removeGood(Good good) {
    goods.remove(good);
    good.setShoppingCart(null);
    return good;
}