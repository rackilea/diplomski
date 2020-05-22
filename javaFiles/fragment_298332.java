@Repository
public interface RuleRepository extends CrudRepository<Rule, Long> {

     // You can easily specify custom finders
     public List<Rule> findByType(String type);

}