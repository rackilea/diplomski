public doInsert(){
  ctx.transaction(configuration -> {
    DSL.using(configuration).insertInto(...);
    DSL.using(configuration).insertInto(...);    
  });
}