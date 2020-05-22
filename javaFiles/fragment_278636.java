@Id
@SequenceGenerator(name = "CategoryIdGenerator", sequenceName = "CategorySeq")
@GeneratedValue(strategy = GenerationType.AUTO, generator = "CategoryIdGenerator")
@Column(name = "categoryId") // not necessary, but makes things clearer
public long getCategoryId() {
    return categoryId;
}

// optional must be true: some categories don't have a parent
@ManyToOne(optional = true, fetch = FetchType.EAGER) 
// insertable at least must be true if you want to create categories with a parent
@JoinColumn(name = "parentCategoryId", nullable = true)
public Category getParent() {
    return parent;
}