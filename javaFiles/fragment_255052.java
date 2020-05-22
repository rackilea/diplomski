public interface UserService {}

@Component
public class SimpleUserService implements UserService {}

@Component
public class JpaUserService implements UserService {

    @Autowired
    UserRepository userRepository
}

public interface UserRepository extends JpaRepository<User, Integer> {}