public class Node {
    @Id
    private Integer id;
    private String nameNode;
    @OneToMany
    @JoinColumn(name = "idAuthorites", referencedColumnName = "idAuthorites", insertable=false, updatable=false)
    private Set<Authority> authorities;
    ...

public class Authority {
    @Id
    private AuthorityPK pk;
    private String person;
    @OneToMany
    @JoinColumn(name = "idAuthorites", referencedColumnName = "idAuthorites")
    private Set<Node> nodes;
    ...