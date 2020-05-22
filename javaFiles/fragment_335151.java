@Document(indexName = xxx, type = xxx)
public class Object1 {
@Field(type = FieldType.Nested)
private List<Obj2> lstObj2;
} 

public class Obj2 {

  private Long id;
 }