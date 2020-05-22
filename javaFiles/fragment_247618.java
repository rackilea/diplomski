//DAO class
@SuppressWarnings("unchecked")
public List<Group> findAllWithUsers(){
    Criteria criteria = getCurrentSession().createCriteria(Group.class);

    criteria.setFetchMode("users", FetchMode.SUBSELECT);
    //Other restrictions here as required.

    return criteria.list();
}