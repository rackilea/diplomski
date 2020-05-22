public class Value implements Serializable {
    public Value(Double a, Float b) {
        this.a = a;
        this.b = b;
    }
    Double a;
    Float b;

    public void setA(Double a) {
        this.a = a;
    }
    public void setB(Float b) {
        this.b = b;
    }
    public Double getA() {
        return a;
    }
    public Float getB() {
        return b;
    }

    public String toString() {
        return "[" +a +","+b+"]";
    }
}


    Multimap<Double, Float> data = LinkedListMultimap.create();
    data.put(1d, 1f);
    data.put(1d, 2f);
    data.put(2d, 3f);

    List<Value> values = data.asMap().entrySet()
            .stream()
            .flatMap(x -> x.getValue()
                    .stream()
                    .map(y -> new Value(x.getKey(), y)))
            .collect(Collectors.toList());

    sqlContext.createDataFrame(sc.parallelize(values), Value.class).show();