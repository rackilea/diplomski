public class FooInfo {
    @SerializedName("foo_sticks")
    public String fooSticks;

    @SerializedName("bar_socks")
    public String[] barSocks;

    @Override
    public String toString() {
        return "FooInfo [fooSticks=" + fooSticks + ", barSocks=" + Arrays.toString(barSocks) + "]";
    }
}