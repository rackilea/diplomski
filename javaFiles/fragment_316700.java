public class ListWrapper<T> {    
    @JsonProperty("@values")
    private List<T> values;

    public static class MyMapListWrapper extends ListWrapper<MyMap> {
    }

    public static class Child1ListWrapper extends ListWrapper<Child1> {
    }
}