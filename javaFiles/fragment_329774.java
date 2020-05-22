import org.hibernate.id.IdentityGenerator;
...
public class UseIdOrGenerate extends IdentityGenerator {
private static final Logger log = Logger.getLogger(UseIdOrGenerate.class.getName());

@Override
public Serializable generate(SessionImplementor session, Object obj) throws HibernateException {
    if (obj == null) throw new HibernateException(new NullPointerException()) ;

    if ((((EntityWithId) obj).getId()) == null) {
        Serializable id = super.generate(session, obj) ;
        return id;
    } else {
        return ((EntityWithId) obj).getId();

    }
}