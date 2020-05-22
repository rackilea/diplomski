@Getter
@Setter
public class Root
    {
        private List<A> a;
    }
@Getter
@Setter
private class A
    {
        private String name;
        private String id;
    }
ObjectMapper mapper = new ObjectMapper();
List <Root> rt = mapper.readValue(json, List.class);