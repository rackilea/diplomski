@Entity
public class Publication extends Research {

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "myReferences")
    // What other publications refer to this one?
    public List<Publication> referencedBy;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "CROSS_REFERENCE",
            joinColumns = {
                    @JoinColumn(name = "MY_ID")
                    },
            inverseJoinColumns = {
                    @JoinColumn(name = "REFERENCER_ID")
            })
    // What publications am I referring to?
    public List<Publication> myReferences;

    // The list of articles in this publication.
    @ManyToMany(cascade = CascadeType.ALL)
    public List<Article> articles;
}