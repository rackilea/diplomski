private static Map<Integer, Integer> yourMap;

static {
    yourMap = new HashMap<Integer, Integer>();
    callTheStaticMethod();
}

public static void callTheStaticMethod() {
    ...
}