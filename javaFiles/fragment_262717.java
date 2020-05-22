public BasketDTO findBasket(String key) {
    return Optional.ofNullable(key) // Optional<String>
            .flatMap(basketRepository::findOneByKey) // Optional<BasketModel>
            .map(BasketDTO::new)        // b -> new BasketDTO(b)
            .orElseGet(BasketDTO::new); // () -> new BasketDTO()
}