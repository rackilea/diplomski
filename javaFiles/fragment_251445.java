@Mapper(uses = {ParentClassMapper.class})
public interface ChildClass1Mapper{

  ChildClass1Dto convertToDto(ChildClass1 p);

  ChildClass1 convertDTOToModel(ChildClass1Dto dto);
}

@Mapper(uses = {ParentClassMapper.class})
public interface ChildClass2Mapper {

  ChildClass2Dto convertToDto(ChildClass2 p);

  ChildClass2 convertDTOToModel(ChildClass2Dto dto);
}