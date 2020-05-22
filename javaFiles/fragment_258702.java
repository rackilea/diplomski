@Entity
@NamedEntityGraph(name = "User.withRoles", attributeNodes = {
    @NamedAttributeNode("roles") // fetch "roles" eager
})
@NamedQuery(name = "User.byName", query = "SELECT u FROM User u WHERE u.name = :name")
public class User {
    /* ... */

    @Column(updatable = false)
    private String name;

    @ManyToMany // fetch lazy by default
    @JoinTable(name = "user_role", /* ... */)
    private Set<Role> roles;
}

public User getUser(String name, boolean withRoles) {
    TypedQuery<User> query = entityManager.createNamedQuery("User.byName", User.class);
    if (withRoles) {
        EntityGraph<User> loadGraph = (EntityGraph<User>) entityManager.createEntityGraph("User.withRoles");
        query.setHint("javax.persistence.loadgraph", loadGraph);
    }

    try {
        return query.setParameter("name", name).getSingleResult();
    } catch (NoResultException ex) {
        return null;
    }
}