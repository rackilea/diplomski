@Mapper(componentModel = "spring", uses = {IdentificationMapper.class})
public interface PersonMapper {


    @Mapping(target = "identificationEntity", source = "identification")
    PersonEntity toPersonEntity(Identification identification);
}