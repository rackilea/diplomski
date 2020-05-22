@ManyToMany(targetEntity = AbstractEntity.class,
        fetch = FetchType.LAZY)
@JoinTable(name = "conflict_affected_entity",
        joinColumns = { @JoinColumn(name = "conflict_id", referencedColumnName = "id") },
        inverseJoinColumns = { @JoinColumn(name = "affected_entity_id", referencedColumnName = "id") })
public Set<AbstractEntity> getAffectedEntities()
{
    Hibernate.initialize(affectedEntities);
    return affectedEntities;
}

public void setAffectedEntities(Set<AbstractEntity> affectedEntities)
{
    this.affectedEntities = affectedEntities;
}