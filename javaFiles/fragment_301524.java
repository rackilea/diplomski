// This will work!
public List<Runner> findByMatchingName(String name)
{
    return super.getHibernateTemplate().find(
    "from Runner r where concat(r.firstname,' ',r.surname) 
     LIKE ?",new String[]{"%"+name+"%"});
}