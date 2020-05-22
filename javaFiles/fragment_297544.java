@AfterMapping
public Profile doAfterMapping(@MappingTarget Profile entity) {
    if (entity != null && entity.getUser().getId() == null) {
        entity.setUser(null);
    }
    return entity;
}