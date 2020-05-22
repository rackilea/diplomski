@SuppressWarnings({"unchecked", "rawtypes"})
HashMap<String, Object>[] array = stream.toArray(new IntFunction<HashMap[]>() {
    public HashMap[] apply(int n) {
        return new HashMap[n];
    }
});