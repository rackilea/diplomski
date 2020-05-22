@Entity
class MyTable {
  @Id
  private int code;
  @Column(name = "SourceFrom", columnDefinition = "varchar(15) default 'Case'")
  private String sourceFrom; 
}