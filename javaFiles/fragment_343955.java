@Entity  
@NamedNativeQuery(name = "SampleNameQuery",query = "call spS_NamedQuery(?,?)",resultSetMapping="mapping",resultClass = NamedQuery.class)  
@SqlResultSetMapping(name="mapping",columns=@ColumnResult(name="value"))        
public class NamedQuery {  

 @Id  
 public String name;  

 @Column  
 public String value;  
}  
                . . . .