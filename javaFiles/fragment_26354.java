package com.test.converter;

public class Converter extends DozerConverter<Set, List> {

   @Autowired
   Mapper mapper;

   public Converter() {
    super(Set.class, List.class);
   }

    @Override
    public List convertTo(Set noteVariableDefinitionPO, List   noteVariableDefinition) {
        //iterate set
        NoteVariableDefinition mappedValue = mapper
                .map(noteVarDefinitionPO,
                        NoteVariableDefinition.class,
                        mappingID);
         // add it to list and return
  }

  @Override
  public Set convertFrom(List arg0, Set arg1) {
    return null;
  }

}