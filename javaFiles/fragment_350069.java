@UserDefinedType // THE SOLUTION
public class ChildDto {
  @Column(value = "child") //OPT
  @CassandraType(type = DataType.Name.TEXT) //OPT
  private String groupId;

  @Column(value = "description") //OPT
  @CassandraType(type = Name.TEXT) //OPT
  private String description;
}