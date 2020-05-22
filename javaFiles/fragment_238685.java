public class AvgBDProjection extends AvgProjection{

    public AvgBDProjection(String propertyName) {
        super(propertyName);
    }

    public Type[] getTypes(Criteria criteria, CriteriaQuery criteriaQuery)
    throws HibernateException {
        return new Type[] { org.hibernate.type.BigDecimalType.INSTANCE };
   }
}