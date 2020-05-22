@Mapper
public MyMapper {

    @Mapping( target = "key.id", source = "keyDto.id")
    @Mapping( target = "key.name", source = "valueDto.name")
    @Mapping( target = "value", source = "valueDto")
    Target dtosToTarget(KeyDto keyDto, ValueDto valueDto);

    Value valueDtoToValue(ValueDto valueDto);
}