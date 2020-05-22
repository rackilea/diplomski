public interface MyInterface {
    public default String string() {
        return (String)process((s,i)->s);
    }
    public default int integer() {
        return (int)process((s,i)->i);
    }
    Object process(BiFunction<String,Integer,?> f);
}