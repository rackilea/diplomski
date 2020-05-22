@Entity
public class Chapter {
    private Set<User> users;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "user_chapters", joinColumns = { 
        @JoinColumn(name = "user_id", nullable = false, updatable = true) }, 
        inverseJoinColumns = { @JoinColumn(name = "chapter_id", nullable = false, updatable = true) 
    })
    public Set<User> getUsers() {
        return users;
    }
}