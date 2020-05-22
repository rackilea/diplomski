@Test
  public void mapStruct_Inheritance_Test() throws Exception {

    ChildClass1Dto childClass1Dto = new ChildClass1Dto();
    childClass1Dto.name = "name1";
    childClass1Dto.anotherParentField = 1;
    childClass1Dto.customCLass1Field = "customCLass1Field1";

    List<ParentClassDto> parentClassDtos = new ArrayList<>();
    ChildClass1Dto childClass11Dto = new ChildClass1Dto();
    childClass11Dto.name = "name12";
    childClass11Dto.anotherParentField = 12;
    childClass11Dto.customCLass1Field = "customCLass1Field12";
    parentClassDtos.add(childClass11Dto);

    ChildClass2Dto childClass21Dto = new ChildClass2Dto();
    childClass21Dto.name = "name12";
    childClass21Dto.anotherParentField = 21;
    childClass21Dto.intField = 210;
    parentClassDtos.add(childClass21Dto);

    childClass1Dto.relation = parentClassDtos;

    ParentClass parentClass = Mappers.getMapper(ParentClassMapper.class).convertDTOToModel(childClass1Dto);
  }