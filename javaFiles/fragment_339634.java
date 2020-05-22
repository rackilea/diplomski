(a, b) -> {

    Integer nexta = a.orderNumbers.iterator().next(),
            nextb = b.orderNumbers.iterator().next();

    if( nexta == nextb ) {
        return a.orderNumbers.size() > b.orderNumbers.size() ? 1 : -1;
    }

    return Integer.compare(nexta, nextb);
}