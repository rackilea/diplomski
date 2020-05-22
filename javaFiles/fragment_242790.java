import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.ibatis.session.SqlSession;

public class ConnectionHandler implements InvocationHandler {

private Object obj;

private static final ThreadLocal<SqlSession> session = new ThreadLocal<SqlSession>();

public static SqlSession getSession(){
    return session.get();
}

public static Object newInstance(Object obj) {
    return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new ConnectionHandler(obj));
}

private ConnectionHandler(Object obj) {
    this.obj = obj;
}

@Override
public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
    Object result = null;

    SqlSession sqlSession = ConnectionFactory.getSqlSessionFactory()
        .openSession(); 
    session.set(sqlSession);
    try {
        result = m.invoke(obj, args);
        sqlSession.commit();
    } catch (Exception e) {
        sqlSession.rollback();
        throw e;
    } finally {
        sqlSession.close();
    }
    return result;
}
}