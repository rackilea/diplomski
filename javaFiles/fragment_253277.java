package beans;

import ...

@SessionScoped
public class UsersBean implements Serializable {

    private String login;

    private String password;

    @Autowired
    private UserService userService;

    ...Getters, setters for every field...

    public void checkRegistred(){
        userService.checkUser(getLogin());
    }

}