import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class UserService{

  @Autowired
  UserRepository userRepository;

  Page<User> findAllUsers(UserSearchCriteria userSearchCriteria){
    if(userSearchCriteria == null){
      userSearchCriteria = new UserSearchCriteria();
    }
    return userRepository.findAll(UserSearchSpecification.findByCriteria(userSearchCriteria), userSearchCriteria.toPageRequest());
  }
}