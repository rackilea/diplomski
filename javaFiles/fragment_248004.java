protected <T> Collection<T> getPageOfContacts(
        Collection<T> contacts, int pageIndex, int pageSize) {
    Iterator<List<T>> partitions = Iterators.partition(contacts.iterator(), pageSize);

    for(int page = 0; page<pageSize && partitions.hasNext(); page++){
        List<T> partition = partitions.next();
        if(page == pageIndex) return partition;
    }
    return Collections. <T> emptyList(); //or fail
}