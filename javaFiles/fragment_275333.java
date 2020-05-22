@Entity
@Table(name = "system_table", schema = "blue_schema")
@SequenceGenerator(schema = "blue_schema", name = "system_table_seq", allocationSize = 1, sequenceName = "system_table_seq")
public class SystemEntity {

    @Id
    @GeneratedValue(generator = "system_table_seq", strategy = GenerationType.SEQUENCE)
    private Integer id;

    // other code below 
    // ... 

}