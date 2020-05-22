public abstract class ParentClassMapperDecorator implements ParentClassMapper {

  private final ParentClassMapper delegate;

  public ParentClassMapperDecorator(ParentClassMapper delegate) {
    this.delegate = delegate;
  }

  @Override
  public ParentClass convertDTOToModel(ParentClassDto dto) {
    ParentClass parentClass = null;

    if (dto instanceof ChildClass1Dto) {
      parentClass = Mappers.getMapper(ChildClass1Mapper.class).convertDTOToModel((ChildClass1Dto) dto);
    } else if (dto instanceof ChildClass2Dto) {
      parentClass = Mappers.getMapper(ChildClass2Mapper.class).convertDTOToModel((ChildClass2Dto) dto);
    } else {
      parentClass = this.delegate.convertDTOToModel(dto);
    }

    return parentClass;
  }

  @Override
  public ParentClassDto convertToDto(ParentClass p) {
    // Do the job here
  }
}