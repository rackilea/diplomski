@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String uuid = UUID.randomUUID().toString();

    @Override
    public boolean equals(Object that) {
        return this == that ||
            that instanceof BaseEntity && Objects.equals(uuid, ((BaseEntity) that).uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}