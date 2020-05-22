class KeyHolder {
    private static Map<String, List<Response>> userCache;

    public static KeyHolder.Builder newBuilder(int id) {
        if(userCache == null) {
            userCache = ...;
        }

        return new Builder(id);
    }
}