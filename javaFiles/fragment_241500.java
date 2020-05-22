public <T> ArrayList<T> filterList(List<? super T> list, Class<T> subClass) {
    return list.stream().
    return list.stream().
            filter(o -> subClass.isInstance(o)).
            map(o -> subClass.cast(o)). // warning-free casting
            collect(Collectors.toCollection(ArrayList::new)); // forcing an ArrayList collector
}