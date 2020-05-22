public interface AuthorRepository extends CrudRepository<Author, Long> {
  List<Author> findByName(String name);    
}

public interface WriterRepository extends CrudRepository<Writer, Long> {
  List<Writer> findByName(String name);    
}