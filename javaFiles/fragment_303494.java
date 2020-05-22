@Local(DaoBean.class)
@Stateless
public class DoaBean{
     private @Inject @Named("sqlSessionFactory") SqlSession session;
     public void doStuff(){
         session.selectOne(...);
     }
     ...
}