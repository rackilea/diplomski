@Caching( put = {
        @CachePut(key = "#code"),
        @CachePut(key = "'TMP_'.concat(#code)")
})
MyObject saveMyObject(MyObject o, String code) {
    return dao.save(o);
}