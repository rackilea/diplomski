@Cacheable("test")
public MyObject getValue(String data) {
    try {
        MyObject result = callServer(data);
        storeResultSomewhereLikeADatabase(result);
    } catch (Exception ex) {
        return getStoredResult(data);
    }
}