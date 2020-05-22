@ManyToMany(cascade = { 
CascadeType.PERSIST, 
CascadeType.MERGE
})
@JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id")
)
private Set<Role> roles = new HashSet<>();