public class...
@PersistenceContext(unitName = "persistence_unit")
private EntityManager em;

...
mymethod(){
...
Query q = em.createNativeQuery("SELECT nextval('groups_group_id_seq')");
BigInteger groupId = (BigInteger)q.getSingleResult();

BigInteger parentId = methodToGetParentId();

GroupsPK gpk = new GroupsPK(groupId, parentId);

Groups grps = new Groups(gpk, "other parameters");

...
}