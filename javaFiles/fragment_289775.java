import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
public class UserSearchCriteria {
    UserSearchCriteria(){
        super();
        sort = "lastName";
    }
    Integer size;
    Integer page;
    String sort;
    String sortDir;

    String firstName;
    String lastName;
    Sort buildSort(){
        return new Sort(new Sort.Order(Sort.Direction.ASC, sort).ignoreCase());
    }
    PageRequest toPageRequest(){
        if(size == null){
            size = Integer.MAX_VALUE; // may or may not be a good idea for your usecase
        }
        return new PageRequest(page, size, buildSort());
    }
}