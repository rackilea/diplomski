orginalList.groupBy { it.dID }.collect { dID, maps ->
    def head = maps.head()

    [
        infos: maps*.info.join('_'),
        brand: head.brand,
        dID: head.dID,
        price: head.price,
        total: maps.size()
    ]
}