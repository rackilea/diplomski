@Autowired
private SessionFactory sessionFactory;

public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
}

@Transactional
public Map getOrgToUserLst() {
    Map<Organization, List<Users>> comToUserLst = new HashMap<Organization,List<Users>>();
    String queryString = "FROM Users as usr Inner Join usr.organization as org where org.id = :id";

    List<?> comLst = this.sessionFactory.getCurrentSession()
            .createQuery(queryString)
            .setParameter(0, Integer.valueOf(id))
            .list();
    Iterator<?> ite = comLst.iterator();

    while (ite.hasNext()) {
        Object[] objects = (Object[]) ite.next();

        Users user = (Users) objects[0];

        Organization Organization = (Organization) objects[1];
        if (comToUserLst.containsKey(Organization)) {
            List<Users> usrLst = new ArrayList<Users>();
            usrLst.addAll(comToUserLst.get(Organization));
            usrLst.add(user);
            comToUserLst.put(Organization, usrLst);
        } else {
            List<Users> userLst = new ArrayList<Users>();
            userLst.add(user);
            comToUserLst.put(Organization, userLst);
        }
    }

    return comToUserLst;
}

@Transactional
public void saveOrganization(Organization org) {
    this.sessionFactory.getCurrentSession().persist(org);
}

@Transactional
public void updateOrganization(Organization org) {
    this.sessionFactory.getCurrentSession().merge(org);
}

@Transactional
public void deleteOrganization(Organization org) {
    getCurrentSession().delete(org);
}

@Transactional
public void deleteOrganizationById(long id) {
    final Organization org = this.getCurrentSession().get(Organization, id);
    this.getCurrentSession().delete(org);
}