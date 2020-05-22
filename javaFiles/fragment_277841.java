@Mapper
public interface MyMapper {

    Source map(Target target);

    @AfterMapping
    void afterMapping(@MappingTarget Source source) {
        if (source.getPhone() != null && source.getPhone().getId() == null) {
            source.setPhone(null);
        }
    }
}