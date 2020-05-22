public <T> List<List<T>> partition(Iterable<T> iterable, int partitions){
    List<List<T>> result = new ArrayList<>(partitions);
    for(int i = 0; i < partitions; i++)
        result.add(new ArrayList<>());

    Iterator<T> iterator = iterable.iterator()
    for(int i = 0; iterator.hasNext(); i++)
        result.get(i % partitions).add(iterator.next());

    return result;
}