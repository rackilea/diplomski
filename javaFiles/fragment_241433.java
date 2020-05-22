@Entity
public class EntityA {
    private EntityB parent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    public EntityB getParent() {
        return parent; 
    }
    ...
}

@MappedSuperclass
public class SuperEntity {
    private long itemId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long getItemId() { 
        return itemId;
    }
    ...
}