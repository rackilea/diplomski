@Mapper
public interface MyMapper {


    MyDTOClass mapMyEntity(MyEntityClass myEntityClass, @Context Server server);

    List<MyDTOClass> mapMyEntity(List<MyEntityClass> myEntityClass, @Context Server server);

    @AfterMapping
    default void afterMapping(@MappingTarget MyDTOClass target, @Context Server server) {
        target.setServer(server);
    }
}