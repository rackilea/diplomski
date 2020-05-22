@ManyToMany(mappedBy="terms")
private Set<Category> categories = new HashSet<Category>();

/* ... */

@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
private Set<Term> terms = new HashSet<>();