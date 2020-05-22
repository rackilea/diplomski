@Transactional(propagation = Propagation.REQUIRES_NEW )
@Override
public boolean registerUser(User user) {
    User userWithTheSameLogin = userDao.getUserByLogin(user.getUserLogin());
    if(!Objects.isNull(userWithTheSameLogin)){
        //if user with the same login registered already
        return false;
    }
    User userWithTheSamePassword = userDao.getUserByEmail(user.getUserEmail());
    if(!Objects.isNull(userWithTheSamePassword)){
        //if user with the same email registered already
        return false;
    }
    //if user's credentials are unique
    userDao.saveUser(user);
    return true;
}