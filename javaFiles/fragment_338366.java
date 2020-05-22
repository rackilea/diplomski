@Mapper(uses = PhoneRepository.class)
interface MyMapper {

    @Mapping(target = "idsPhones", source = "phones")
    Target toTarget(Source source);

    @InheritInverseMapping
    Source toSource(Target target);

    default Long fromPhone(Phone phone) {
        return phone.getId();
    }
}