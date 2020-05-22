@Entity
@Table(name="PARENT_TABLE")
@AttributeOverrides({
    @AttributeOverride(name="someProperty", column=@Column(name="someProperty"))
})
public class Parent extends AbstractParent {}