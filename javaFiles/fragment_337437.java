@Repository
public class EmployeeDaoImpl extends AbstractHibernateDao implements EmployeeDao{
public Employee getSalaryDetails(Integer empId)
{
    Session session = getCurrentSession();
    Query query = session.getNamedQuery("getEmpSalaryDtls");
    query.setInteger("empId", empId);
    query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
    Map map = (Map) query.uniqueResult();
    return map;
}