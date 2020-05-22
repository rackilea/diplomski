@Entity
@Table.....
public class Article {

    @Id
    @Column
    private Integer id,

    @OneToMany(mappedBy="parentArticle")        
    private Set<Article> childArticles;

    @ManyToOne
    @JoinColumn(name="parent_id")
    private Article parentArticle

    @Column
    private String name,text
    ...