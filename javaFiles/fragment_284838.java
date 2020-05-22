public static <T> Mono<T> addContext(Mono<T> source){
    return source.subscriberContext( context -> {
        Context context1 = context.put("key", "Hello");
        System.out.println((String) context1.get("key"));
        return context1;
    });
}