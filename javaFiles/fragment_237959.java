@Mapper
public interface ObjectMapper {

    ObjectMapper INSTANCE = Mappers.getMapper(ObjectMapper.class);

    A mapToA(B b);

    B mapToB(A a);
}