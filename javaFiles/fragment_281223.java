@Entity
@Table(name = "mytable")
public class MyEntity {

    @Id
    private String key;

    @Convert(converter=MyPojoToJsonConverter.class)
    private MyPojo content;
}