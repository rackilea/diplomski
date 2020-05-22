@ManyToMany(targetEntity = Conflict.class,
        fetch = FetchType.LAZY)
@JoinTable(name = "conflict_affected_entity",
        joinColumns = { @JoinColumn(name = "affected_entity_id", referencedColumnName = "id") }, 
        inverseJoinColumns = { @JoinColumn(name = "conflict_id", referencedColumnName = "id") })
public Set<Conflict> getConflicts()
{
    Hibernate.initialize(conflicts);
    return conflicts;
}

public void setConflicts(Set<Conflict> conflicts)
{
    this.conflicts = conflicts;
}