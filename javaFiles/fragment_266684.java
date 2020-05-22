@Transactional
public List<ShopData> updateShop(User user, ShopData shopData) {
  Shop updateShop = mapper.map(shopData, Shop.class);
  entityManager.merge(updatedShop);
  return getUserShops(user);
}