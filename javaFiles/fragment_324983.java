@Remote(IMyInterface.class)
@Stateless(mappedName="ejb/service/IMyInterface")
public class MyClass implements IMyInterface {

    @EJB
    private IMyUserDao userDao;

    @Override
    public void doSomething() {
        User user = userDao.get(1);
        System.out.println(user.getName());
    }

}