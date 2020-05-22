@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "\"USER_ROLE_MAPPING\"", catalog = "\"PLATFORM_PROD_IOT\"", joinColumns = { 
            @JoinColumn(name = "\"USER_ID\"", nullable = false, updatable = false) }, 
            inverseJoinColumns = { @JoinColumn(name = "\"ROLE_ID\"", 
                    nullable = false, updatable = false) })
    private Set<Role> roles = new HashSet<>();


public Set<Role> getRoles() {
    return roles;
}

public void setRoles(Set<Role> roles) {
    this.roles = roles;
}