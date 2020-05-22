public class Linspace {
    private float current;
    private final float end;
    private final float step;
    public Linspace(float start, float end, float totalCount) {
        this.current=start;
        this.end=end;
        this.step=(end - start) / totalCount;
    }
    public boolean hasNext() {
        return current < (end + step/2); //MAY stop floating point error
    }
    public float getNextFloat() {
        current+=step;
        return current;
    }
}