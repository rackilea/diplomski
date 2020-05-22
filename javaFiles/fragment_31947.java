public class Payload {

    private List<MyBean> myBeans = new ArrayList<MyBean>();

    //the JSON returned has blank values for myBeans.values.items
    public String toJson() {
            return new JSONSerializer()
                .exclude("*.class")
                .include("myBeans")
                .transform(new SOMapTransformer(), Map.class)
                .serialize(this);
    }
}


public class MyBean {

    private Map<String, List<SomeBean>> items = new HashMap<String, List<SomeBean>>();

    //this works
    public String toJson() {
            return new JSONSerializer()
                .exclude("*.class")
            .transform(new SOMapTransformer(), "items")
                .deepSerialize(this);
    }
}