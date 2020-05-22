private Set<Unit> units;

@ManyToMany
@JoinTable(name="UNIT", joinColumns={@JoinColumn(name="ID")}, 
           inverseJoinColumns={@JoinColumn(name="U_ID")}
)
public Set<Unit> getUnits() {
    return units;
}