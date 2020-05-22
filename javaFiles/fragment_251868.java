@WebService(serviceName = "AddUserService")
@Stateless()
public class AddUserService {

    //actually you don't need this here, you'll get that injected inside the UserEJB
    @PersistenceContext(unitName = "UserRegistrationService-ejbPU")
    EntityManager em;


    @Inject
    UserEJB userEjb;

    @WebMethod(operationName = "registerUser")
    public String registerUser(BasicUserInfo basicUserInfo) {
        //you don't need this line, the container will instantiate the object for you!
        //UserEJB userEJB=new UserEJB(em);
        String retValue = "";
        User user = new User();
        user.setAge(basicUserInfo.getAge());
        user.setUserName(userName);
        userEJB.addUser(user);
        retValue = " User Registered with user_ID:" + user.getId().toString() + "  and         userName:" + user.getUserName();
        return retValue;
    }
}