// a map containing all elements searchable by the rowId
HashMap<String, MultiAdminComponent> idToItem = new HashMap<>();
// a set containing all elements that don't have a parent (id: 1, 2, 3, etc.)
Set<MultiAdminComponent> rootItems = new HashSet<>();

for (MultiAdminComponent item : componentList) {
    // build the id->item map
    idToItem.put(item.getRowId(), item);
}

for (MultiAdminComponent item : componentList) {
    String parentId = getParentId(item.getRowId());
    if (parentId == null) {
        // this item has no parent -> it is a root item
        rootItems.add(item);
    } else {
        // This item has a parent -> look the parent up
        MultiAdminComponent parent = idToItem.get(parentId);
        parent.getItems().add(item);
    }
}

// rootItems now contains all MultiAdminComponents which do not have a parent, with the correct hierarchy for all items