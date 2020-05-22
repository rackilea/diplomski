public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
  public User getUser(String userId) {
    return (User)getSqlSession().selectOne(
        "org.mybatis.spring.sample.mapper.UserMapper.getUser", userId);
  }
}