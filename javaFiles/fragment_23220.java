public static String safeFormat(String formatStr, Object... args) {
    String result = String.format(formatStr, args);

    List<Object> objects = Arrays.asList(args);
    //https://commons.apache.org/proper/commons-lang/javadocs/api-3.7/org/apache/commons/lang3/mutable/MutableBoolean.html
    MutableBoolean isCalled = new MutableBoolean(false);
    objects.add(new Object(){
        @Override
        public String toString() {
            isCalled.setTrue();
            return "";
        }
    });
    //noinspection ResultOfMethodCallIgnored
    String.format(formatStr+" %s", objects.toArray());
    if(isCalled.isFalse()) {
        throw new IllegalArgumentException("Not all arguments used by formatter");
    }
    return result;
}