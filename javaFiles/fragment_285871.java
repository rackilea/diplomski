class ImmutableType {
    private static final Map<Definition, ImmutableType> POOL = new HashMap<>();

    private final Definition definition;

    private ImmutableType(Definition def) {
         definition = def;
    }

    public static ImmutableType get(Definition def) {
         if(POOL.contains(def))
              return POOL.get(def);
        else {
              ImmutableType obj = new ImmutableType(def);
              POOL.put(def, obj);

              return obj;
        }
    }
}