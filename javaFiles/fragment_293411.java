@ManyToMany(cascade=CascadeType.PERSIST)
public Set<Tag> tags;

public Post(User author, String title, String content) {
    ...
    this.tags = new TreeSet<Tag>();
    ...
    this.title = title;
    this.content = content;
    ...
}