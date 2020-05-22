public byte[] getImageForOrderItem(long itemId) {
    Optional<OrderItemDO> option = orderItemRepository.findById(itemId);
    if(option.isPresent()) {
        OrderItemDO itemDO = option.get();
        if(itemDO.getImage() != null) {
            byte[] image = itemDO.getImage();
            return image;
        }
    }
    return null;
}