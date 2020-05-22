@Repository
public class UserDAOImpl extends GenericRepositoryImplementation< UsersEntity> implements UserDAO {
     public UserDaoImpl() {
          super(UsersEntity.class);
     }
}