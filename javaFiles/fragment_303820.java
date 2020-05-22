@Entity
public class MyEntity {
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "simple_fk"), name = "simple_id", referencedColumnName = "id")
    private Simple simple;

    @ManyToOne
    @JoinColumns(foreignKey = @ForeignKey(name = "composite_fk"), value = {
        @JoinColumn(name = "composite_id1", referencedColumnName = "id1"),
        @JoinColumn(name = "composite_id2", referencedColumnName = "id2") })
    @org.hibernate.annotations.ForeignKey(name = "composite_fk")
    private Composite composite;
}