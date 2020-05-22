@Entity
@Table(name = "DestinationAlias", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "idDestination", "alias" }) })
public final class DestinationAlias {
    // ....
}