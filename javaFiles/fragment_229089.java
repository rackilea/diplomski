// Sort by name
Collections.sort(items, new Comparator<Item>() {

    @Override
    public int compare(Item o1, Item o2) {
        return o1.name.compareTo(o2.name);
    }

});

// at this point, items will be ordered by name