public Integer getTinyLength (Big big) {
    return Optional.ofNullable(big)
        .map(Big::getSmall)
        .map(Small:getTiny)
        .map(Tiny::getTinyLength)
        .orElse(null);
}