public class Result implements Comparable<Result> {
    private String result;
    private float confidence;

    @Override
    public int compareTo(Result other) {
        return Float.compare(this.confidence, other.confidence);
    }
}