//Service Class
@Transactional
public Group findWithUsers(UUID groupId){
    Group group = groupDao.find(groupId);

    //Forces the initialization of the collection object returned by getUsers()
    Hibernate.initialize(group.getUsers());

    return group;
}