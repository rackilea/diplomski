@Repository("myFirstDao")
@Transactional(value="myTransactionManager")
class FirstDaoImpl implements FirstDao
{
@PersistenceContext(unitName="myUnit")
EntityManager em;

           @Transactional(value="myTransactionManager")
           public FirstEntity save(FirstEntity entity)
           {
           return em.merge(entity);
           }

}