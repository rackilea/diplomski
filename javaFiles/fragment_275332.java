@Entity
@Table(name = "system_table", schema = "blue_schema")
@SequenceGenerator(schema = "blue_schema", name = "system_table_seq", allocationSize = 1, sequenceName = "system_table_seq")
public class SystemEntity {

    // other code below 
    // ... 

}