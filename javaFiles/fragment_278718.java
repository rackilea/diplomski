static Future<Object> executeBy(ExecutorService executor) {
    return executor.submit(() -> {
        throw new IllegalStateException() {
                @Override
                public String toString() {
                    String s = getClass().getSuperclass().getName();
                    String message = getLocalizedMessage();
                    return message!=null? s+": "+message: s;
                }
            };
    });
}