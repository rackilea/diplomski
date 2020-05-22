@Entity
public class EntityWithGeneratedField {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "LAST_UPDATED_DTTM", insertable = false, updatable = false,
            columnDefinition = "Date default CURRENT_DATE")
    @org.hibernate.annotations.Generated(value = GenerationTime.INSERT)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastUpdDTTM;

    // getters, setters
}