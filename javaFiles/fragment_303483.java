@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorFormula(
    "CASE WHEN TYPE IN ('SUBTYPE', 'SUBTYPE-2', ...) THEN TYPE ELSE 'BaseEntity'")
public class BaseEntity {
    // . . .
}

@Entity
@DiscriminatorValue("SUBTYPE")
public class SubclassEntity extends BaseEntity {
    // ...
}