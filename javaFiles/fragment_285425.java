public class GsonDoubleAdapterTest {
    public static void main(String[] args) {
        GsonBuilder builder = new GsonBuilder();

        builder.registerTypeAdapter(Double.class, new DoubleAdapter());

        Gson gson = builder.create();
        Foo foo = gson.fromJson("{\"baz\": 0.123456}", Foo.class);
        System.out.println(foo);
    }
}

/**
 * A type adapter that rounds doubles during read.
 */
class DoubleAdapter extends TypeAdapter<Double> {
    @Override
    public void write(JsonWriter out, Double value) throws IOException {
        out.value(value);
    }

    @Override
    public Double read(JsonReader in) throws IOException {
        return new BigDecimal(in.nextDouble()).setScale(4, RoundingMode.HALF_UP).doubleValue();
    }
}

class Foo {
    private Double baz;

    public Double getBaz() {
        return baz;
    }

    public void setBaz(Double baz) {
        this.baz = baz;
    }

    @Override
    public String toString() {
        return "Foo[baz=" + baz + ']';
    }
}