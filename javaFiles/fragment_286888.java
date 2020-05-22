public class  MeuRepositoryImpl implements  MeuRepositoryCustom{

@PeristenceContext
private EntityManager em; // here you will get plain EntityManager impl.

List<MeuEntity> findCustomNativeQuery(String query){

 TypedQuery<MeuEntity> q=em.createQuery(query,MeuEntity.class)
 return q.getResultList();
}
}