public Image findMainImage(Collection<? extends Image> images) {
    return findMainImageHelper( images );
}

private <I extends Image> I findMainImageHelper(Collection<I> images) {
    // ...
}