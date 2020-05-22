@Mapper
public interface FooMapper {


    default Map<String, Foo> convertFooListToMap(List<Foo> foos) {
      // custom logic using streams or however you like.
    }
}