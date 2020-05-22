class User extends MySuperModel{
    int id;
    String username;
    //getters and setters
}

class UserController{
    User getUserById(int id);
    int getUsersCount();
}