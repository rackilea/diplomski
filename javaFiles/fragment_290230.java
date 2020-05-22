Item similarItem = ((Supplier<Item>) (() -> {
    for (Item i : POSSIBLE_ITEMS) {
        if (i.name.equals(this.name)) return i;
    }
    return null;
})).get();