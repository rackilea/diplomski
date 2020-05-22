@Named
public class myBean {

  @PersistenceContext
  private EntityManager em;

  public Book getBookById(Long id) {
   return em.find(Book.class, id);
  }
}