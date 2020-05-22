public class WhereverYouWantThis {

    private static HashMap<Class<?>, HashMap<Class<?>, Function<?, ?>>> converters = new HashMap<>();

    static {
        putConverter(String.class, Float.class, Float::parseFloat);
    }

    private static <T, R> void putConverter(Class<T> t, Class<R> r, Function<T, R> func) {
        HashMap<Class<?>, Function<?, ?>> map = converters.get(t);
        if(map == null) converters.put(t, map = new HashMap<>());
        map.put(r, func);
    }

    public static <T, R> Function<T, R> getConverter(Class<T> t, Class<R> r) {
        HashMap<Class<?>, Function<?, ?>> map = converters.get(t);
        if(map == null) return null;
        @SuppressWarnings("unchecked")
        Function<T, R> func = (Function<T, R>) map.get(r);
        return func;
    }

    public static <T, R> R convert(T o, Class<R> to) {
        @SuppressWarnings("unchecked")
        Function<T, R> func = (Function<T, R>) getConverter(o.getClass(), to);
        return func == null ? null : func.apply(o);
    }

}