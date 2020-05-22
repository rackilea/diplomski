@Mapper(uses = Mapper1.class)
public interface MyMapper {

    @Mapping(source = "from.id", target = "ref")
    To get(From from);
}