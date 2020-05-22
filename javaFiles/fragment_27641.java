class CustomStreamImpl<T> implements CustomStream<T>{
    private final Stream<T> stream;

    public CustomStreamImpl(Stream<T> stream){
        this.stream = stream;
    }

    public CustomStreamImpl<T> something(){
        // your action below
        Stream<T> newStream = stream
            .filter(o -> o != null)
            .collect(Collectors.toList())
            .stream(); 
        return new CustomStreamImpl<T>(newStream);
    }

    // delegate all the other methods to private stream instance
}