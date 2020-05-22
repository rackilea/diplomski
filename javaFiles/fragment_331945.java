@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Data
public class NodeElement {
    @Id
    private String id;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ElementPosition elementPosition;
}