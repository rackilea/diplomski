@Entity
@Table(name = "B")
@DiscriminatorValue("X")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)    
public class BExt extends B {
     @Column(name = "B_MY_FIELD")
     private String newField;
}