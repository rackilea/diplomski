@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
@JoinTable(name = "t_aircraft_entity_relation",joinColumns = {
        @JoinColumn(name = "aircraftid", nullable = false, updatable = false)},
        inverseJoinColumns = { @JoinColumn(name = "entityid",nullable = false,updatable= false)         
})
private Set<com.airbushelicopter.ahead.db.pojo.Entity> entities ;