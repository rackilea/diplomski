private static ThreadLocal<List<String>> myThreadLocal =
    new ThreadLocal<List<String>>() {
        @Override public List<String> initialValue() {
            return new ArrayList<String>();
        }
    };