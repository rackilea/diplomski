@Entity
@IdClass(SuperPK.class)
public static class ChildEntity extends SuperEntity {
    @Id
    private String lang;

    @Override @Id
    public Long getId() {
        return super.getId();
    }
}