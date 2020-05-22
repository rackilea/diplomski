public Image findMainImage(
    Collection<? extends Image> images1,
    Collection<? extends Image> images2
) {
    return images1.stream()
                  .filter(Image::isMain)
                  .findFirst()
                  .orElse(images2.iterator().next());
}