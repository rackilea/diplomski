@Override
public Image findImage(int itemId) {
    LOGGER.info("Getting image by item id: {}", itemId);
    Optional<Image> opt = this.imageDAO.findImage(itemId); <== parameterize Optional
    return opt.orElseThrow(() -> new ImageNotFound("The image for item with id: " + itemId + " was not found"));
}