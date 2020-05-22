@Repository
public class UserDaoImpl implements UserDao{

@Autowired
UserContainer container;

@Override
public List<UserBean> getUsers(){
    return container.getUserList();
}

@Override
public void addUser(String name) {
    UserBean userBean = new UserBean();
    userBean.setName(name);
    getUsers().add(userBean);
}
}