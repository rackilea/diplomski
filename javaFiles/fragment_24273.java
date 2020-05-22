public class MyResult {
    private final Dynamic bucket;

    public Result(Dynamic bucket) {
        this.bucket = bucket;
    }

    public String getKey() {
        return bucket.get("key_as_string").asString();
    }

    public double getAppleToOrangeRatio() {
        double apples = bucket.dget("Apples.value").convert().intoDouble();
        double oranges = bucket.dget("Oranges.value").convert().intoDouble();
        return oranges / apples;
    }
}