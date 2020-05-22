public <I extends Image> I findMainImage(Collection<I> images) {
    if (images == null || images.isEmpty()) return null;
    return images.stream()
                 .filter(Image::isMain)
                 .findFirst()
                 .orElse(images.iterator().next());
}