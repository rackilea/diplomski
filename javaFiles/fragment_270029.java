public String getNameById(List<Item> items, long id) {
    // boundary condition
    if (items == null || items.isEmpty()) {
        return null;
    }
    // looping
    for (Item item : items) {
        // if current is
        if (item.getId() == id) {
            return item.getName();
        }
        // recursion
        String name = getNameById(item.getSubItemsList(), id);
        // if nested found
        if (name != null) {
            return name;
        }
    }
    // boundary condition
    return null;
}