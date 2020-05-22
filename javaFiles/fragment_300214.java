package util;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.hibernate.HibernateUtil;

import com.lm.action.ActionsConstants;
import com.lm.action.user.Constants;
import com.lm.dao.DAO;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class HibernateSessionTransInjectorInterceptor implements Interceptor, Constants, ActionsConstants {


    private static final long serialVersionUID = -8734958511612355789L;

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private transient Logger log = Logger.getLogger(HibernateSessionTransInjectorInterceptor.class);

    @Override
    public void destroy() {
    }

    @Override
    public void init() {
    }

    @Override
    public String intercept(final ActionInvocation invocation) throws Exception {
        String res=null;
        DAO dao=null;
        try {
            Session s=sessionFactory.openSession();
            dao = new DAO(s);
            dao.beginTransaction();
            **invocation.getStack().setValue("dao", dao, true);**
            res=invocation.invoke();
            boolean rollback=(Boolean)invocation.getStack().findValue("rollbackTransaction", Boolean.class);
            if (rollback)
                dao.rollBackTransaction();
            if (!dao.getT().wasRolledBack())
                dao.commitTransaction();
        } catch (Throwable t2) {
            log.error(t2,t2);
            if (dao!=null)
            try {
                dao.rollBackTransaction();
            } catch (Throwable t3) {
                log.error(t3,t3);
            }
        } finally {
            if (dao!=null)
            try {
                dao.finallyClose();
            } catch (Throwable t) {
                log.error(t,t);
            }
        }
        return res;
    }

}