@Entity
public class Service extends AbstractEntity<Long> {
    private static final long serialVersionUID = 9116959642944725990L;
    @ElementCollection(fetch = FetchType.EAGER, targetClass = java.lang.String.class)
    @CollectionTable(name = "service_tags", joinColumns = @JoinColumn(name = "s_id"))
    @Column(name = "tag")
    private Set<String> tags;
}