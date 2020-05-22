@ManyToMany(mappedBy = "posts", 
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Tag> tags;




@ManyToMany(cascade = 
        {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "post_tag",
        joinColumns = {
            @JoinColumn(
                name = "tag_id", 
                referencedColumnName = "id"
            )
        },
        inverseJoinColumns = {
            @JoinColumn(
                name = "post_id", 
                referencedColumnName = "id"
            )
        }
    )
private List<Post> posts;