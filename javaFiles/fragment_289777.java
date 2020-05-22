import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
public class UserSearchSpecification{

  public static Specification<User> findByCriteria(final UserSearchCriteria searchCriteria){
    return new Specification<User>() {

      @Override
      Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<Predicate>();

        // if firstName in criteria, do an uppercase prefix match
        if(searchCriteria.firstName != null){
          predicates.add(
            cb.like(
              cb.upper(root.get("firstName")),
              "%" + searchCriteria.lastName.toUpperCase()
            )
          );
        }

        // if lastName in criteria, do an uppercase prefix match
        if(searchCriteria.lastName != null){
          predicates.add(
            cb.like(
              cb.upper(root.get("lastName")),
              "%" + searchCriteria.lastName.toUpperCase()
            )
          );
        }
        if(predicates.size() > 0){
          return cb.and(predicates.toArray());
        }else{
          return null;
        }
      }
    }
  }
}