@Entity
@Table(name = "fields")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class AbstractField extends AbstractEntity {

    private FieldType fieldType;
    private String title;
    private Template template;
}