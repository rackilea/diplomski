public class RegisterBean {    
    @EJB MyService service;

    public void register() {
        //TODO: validate username and password
        User newUser = new User();
        newUser.setPassword(password);
        newUser.setUserName(name);
        service.create(newUser);
    }
}