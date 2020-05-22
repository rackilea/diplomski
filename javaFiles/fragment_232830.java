public <T> ArrayList<?> getAllItems(Class<T> clazz) {
    for (ArrayList<?> itemList : wardrobe) {
        Iterator<?> iterator = itemList.iterator();
        if(iterator.hasNext()){
            Object next = iterator.next();
            if(next.getClass().equals(clazz)) return itemList;
        }
    }
    return null;
}