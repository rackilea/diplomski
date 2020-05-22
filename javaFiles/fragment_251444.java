@Mapper
@DecoratedWith(ParentClassMapperDecorator.class)
public interface ParentClassMapper {

  ParentClassDto convertToDto(ParentClass p);

  ParentClass convertDTOToModel(ParentClassDto dto);
}