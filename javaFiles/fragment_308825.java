interface StringSink extends Serializable { void dump(String s); }

class MultiDumper implements Serializable {
    private final StringSink sink;
    public MultiDumper(StringSink sink){ this.sink = sink; }
    void doSomeStuff(Collection<String> strings){
        for (String s : strings) sink.dump(s);
    }
}