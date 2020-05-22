@Transactional
public User retrieveUser(String username)
{
    User user = hibernateUserDao.getUserByUsername(username) 
    /*whatever your method of getting something from the database */

    Collection collection = user.getCollection();
    /*Then you can access and manipulate the collection object*/
}