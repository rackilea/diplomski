public class Access implements Serializable {
    // ...
    @ManyToMany(mappedBy="listAccess")
    private List<Role> listRole;
   // ...
}

public class Role implements Serializable {
    // ...
    @ManyToMany
        @JoinTable(name = "access_role",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "access_id", referencedColumnName = "id"))
    private List<Access> listAccess;
    // ...
}