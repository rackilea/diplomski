public class One {
    public long param;
    @JsonProperty("Two")
    public List<Two> two;

    public static class Two{
        public long param;
        public List<Short> param2;
    }
}