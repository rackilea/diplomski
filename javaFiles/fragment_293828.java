private UserDao userDao = new UserDao();

public String execute() throws Exception {
    User u = new User();
    u.setAddress(address);
    u.setEmail(email);
    u.setName(name);
    u.setPhno(phno);
    u.setPwd(pwd);
    userDao.addUser(u);
    return "success";
}