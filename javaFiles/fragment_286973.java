interface IgnoreThrowing<F,V> extends Function<F,V> {
    public default V apply(F from) {
        try {
            return ignore(from);
        } catch(Exception e) {
            return null;
        }
    }
    public V ignore(F from) throws Exception;
}

class Throwables {
    public static <F,V> Function<F,V> ignore(IgnoreThrowing<F,V> f) {
        return f;
    }
}

static {
    files.map(Throwables.ignore(ImageIO::read)).collect(...)
}