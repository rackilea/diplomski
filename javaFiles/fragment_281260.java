@Transactional(propagation = Propagation.MANDATORY)
public doInsert(){
  ctx.transaction(configuration -> {

    // Wrap configuration in a new DSLContext:
    DSL.using(configuration).insertInto(...);
    DSL.using(configuration).insertInto(...);    
  });
  throw new RuntimeException(":)");
}