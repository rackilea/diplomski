// Sort by price
Collections.sort(items, new Comparator<Item>() {

    @Override
    public int compare(Item o1, Item o2) {
        return o1.price.compareTo(o2.price);
    }
});

// at this point, items will be ordered by price