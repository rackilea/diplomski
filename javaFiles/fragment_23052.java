public class Pair implements Writable {

    public FloatWritable max = new FloatWritable();
    public Text country = new Text();

    public void set(Pair p) {
        this.max.set(p.max.get());
        this.country.set(p.country);
    }
}