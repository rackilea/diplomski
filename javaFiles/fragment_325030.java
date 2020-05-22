private final Keyword REFERENCE_TIME = Keyword.intern("reference-time");
private final Keyword MIN = Keyword.intern("min");
private final Keyword MAX = Keyword.intern("max");

public void extract(String input) {

    PersistentArrayMap datemap = (PersistentArrayMap) Clojure.var("duckling.time.obj", "t").invoke(-5, 2017, 2, 21, 23, 30, 0);
    PersistentArrayMap minMap = (PersistentArrayMap) Clojure.var("duckling.time.obj", "t").invoke(-5, 1900);
    PersistentArrayMap maxMap = (PersistentArrayMap) Clojure.var("duckling.time.obj", "t").invoke(-5, 2100);
    Object[] contextArr = new Object[6];
    contextArr[0] = REFERENCE_TIME;
    contextArr[1] = datemap;
    contextArr[2] = MIN;
    contextArr[3] = minMap;
    contextArr[4] = MAX;
    contextArr[5] = maxMap;
    PersistentArrayMap cljContextMap = PersistentArrayMap.createAsIfByAssoc(contextArr);

    LazySeq results = (LazySeq) Clojure.var("duckling.core", "parse").invoke("en$core", input, dims, cljContextMap);
}