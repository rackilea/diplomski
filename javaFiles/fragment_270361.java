Mono<Map<Long, Product>> fetchProducts(List<Long> refs) {
    return Mono.fromCallable(() -> jdbc.query(SELECT * from products where ref IN(:refs),params))
        .subscribeOn(Schedulers.elastic());
}

Mono<Map<Long, Item>> fetchItems(List<Long> refs) {
    return Mono.fromCallable(() -> jdbc.query(SELECT * from items where ref IN(:refs),params))
        .subscribeOn(Schedulers.elastic());
}

Mono<Map<Long, Warehouse>> fetchWarehouses(List<Long> refs) {
    return Mono.fromCallable(() -> jdbc.query(SELECT * from warehouses where ref IN(:refs),params))
        .subscribeOn(Schedulers.elastic());
}