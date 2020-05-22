List<AbstractObjectDto> map(List<? extends AbstractObject> value);

List<AbstractObject> mapDto(List<? extends AbstractObjectDto> value);

@ObjectFactory
default AbstractObjectDto createDto() {
    return null; // implement your own logic
}

@ObjectFactory
default AbstractObject createEntity() {
    return null; // implement your own logic
}