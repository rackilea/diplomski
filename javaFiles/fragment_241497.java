public <T> List<T> filterList(List<? super T> list, Class<T> subClass) {
    return list.stream().
            filter(o -> subClass.isInstance(o)).
            map(o -> (T) o).
            collect(Collectors.toList());
}