public <T extends Identifiable> T find(UUID id, List<T> items) {
    for (T item : items) {
        if (item.getId().equals(id))
            return item;
    }
    return null;
}