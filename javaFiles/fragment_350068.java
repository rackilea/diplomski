@Table(value = "my_table") //OPT
public class MyTableDto {
  @PrimaryKeyColumn(name = "uid", type = PrimaryKeyType.PARTITIONED) 
  @CassandraType(type = DataType.Name.UUID)
  private UUID uid;

  @Column(value = "child_ids") //OPT
  private List<ChildDto> childIds;
}