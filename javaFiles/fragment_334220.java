enum Type{
    X("S1"),
    Y("S2");

    private static class Holder {
        static Map<String, Type> MAP = new HashMap<>();
    }

    private Type(String s) {
        Holder.MAP.put(s, this);
    }

    public static Type find(String val) {
        Type t = Holder.MAP.get(val);
        if(t == null) {
            throw new IllegalStateException(String.format("Unsupported type %s.", val));
        }
        return t;
    }
}