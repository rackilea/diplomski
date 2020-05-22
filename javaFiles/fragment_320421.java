@MappedSuperclass
public abstract class OpsItem extends Model {

    @ManyToOne
    public RetailOpsBranch report;
}

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AItem extends OpsItem {
...
}

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BItem extends OpsItem {
...
}