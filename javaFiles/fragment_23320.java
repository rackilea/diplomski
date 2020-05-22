@Entity
@Table(name = "articles")
public class Article implements Serializable{
   //other things

   @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
   private List<Tag> tags;
}

@Entity
@Table(name = "tags")
public class Tag implements Serializable{
    //other things

    @ManyToMany(mappedBy="tags" ,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Article> articles;
}