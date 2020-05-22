Stream<Task> getAll(){
    Stream.Builder<Task> all2 = Stream.builder();

    all2.add(item1);
    ..

    return all2.build();
}