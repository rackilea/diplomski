public class MyDTO {
  private String dtoTitle;
  private String dtoEdition;
  // + setters/getters
}


Criteria c = session.createCriteria(Book.class,"b");
c.createAlias("title", "t");
c.add(
    Restrictions.disjunction()
    .add( Restrictions.like("t.title", "%Java%") )
    .add( Restrictions.eq("b.edition", 4) )
);
c.setProjection( 
    Projections.projectionList()
    .add( Projections.property("t.title"), "dtoTitle" )
    .add( Projections.property("b.edition"), "dtoEdition" )
);
c.setResultTransformer(Transformers.aliasToBean(MyDTO.class));
List<MyDTO> result = (List<MyDTO>)c.list();