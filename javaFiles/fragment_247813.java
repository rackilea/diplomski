class Library {

  @Id
  private Integer id;

  @OneToMany
  private List<Book> books;

  // getters and setters    
}

class Book {

  @Id
  private Integer id; 

  @ManyToOne
  private Libraby library;

  // getters and setters
}