public Long objectSize(Object object) {
    List<Object> objectList = getRefs(object);
    long sum = sizeOf(object);

    for(Object object : objectList) {
         sum += objectSize(object);
    }

    return Long.valueOf(sum);
}