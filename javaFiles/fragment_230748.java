@Stateless
public class MyClass{
    @PersistenceContext
    EntityManager em;

    public void updateABC(){
       A a= em.find(A.class, aId);
       //here update some fields on the entity "a"

       B b= em.find(B.class, bId);
       //here update some fields on the entity "b"
       C c= em.find(C.class, cId);
       //here update some fields on the entity "c"
    }
}