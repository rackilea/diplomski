import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Aspect
@Order(Ordered.LOWEST_PRECEDENCE)
public class DbmsOutputAspect {

    private static final Logger LOGGER = Logger.getLogger(DbmsOutputAspect.class);

    @Autowired
    protected SessionFactory sessionFactory;
    /**
     * make Dbms output aware enable/disable configurable in spring bean declaration
     */
    private boolean enable = true;
    private int size = 1000000;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(final boolean enable) {
        this.enable = enable;
    }

    public int getSize() {
        return size;
    }

    public void setSize(final int size) {
        this.size = size;
    }

    @Pointcut("execution(@DbmsOutput * *(..))")
    public void DbmsOutputInterceptMethod() {
    }

    @Around("DbmsOutputInterceptMethod()")
    public Object around(final ProceedingJoinPoint point)
            throws Throwable {

        if (isEnable()) {
            LOGGER.debug("before DBMS_OUTPUT point cut");
            Query queryEnable = sessionFactory.getCurrentSession().createSQLQuery("call dbms_output.enable(:size)");
            queryEnable.setParameter("size", getSize());
            queryEnable.executeUpdate();
        }
        try {
            return point.proceed(point.getArgs());
        } finally {
            if (isEnable()) {
                sessionFactory.getCurrentSession().doWork(new Work() {

                    @Override
                    public void execute(final Connection connection)
                            throws SQLException {

                        CallableStatement show_stmt = connection.prepareCall(
                                "declare " +
                                        " l_line varchar2(255); " +
                                        " l_done number; " +
                                        " l_buffer long; " +
                                        "begin " +
                                        " loop " +
                                        " exit when length(l_buffer)+255 > :maxbytes OR l_done = 1; " +
                                        " dbms_output.get_line( l_line, l_done ); " +
                                        " l_buffer := l_buffer || l_line || chr(10); " +
                                        " end loop; " +
                                        " :done := l_done; " +
                                        " :buffer := l_buffer; " +
                                        "end;");
                        int done = 0;

                        show_stmt.registerOutParameter(2, java.sql.Types.INTEGER);
                        show_stmt.registerOutParameter(3, java.sql.Types.VARCHAR);

                        for (;;) {
                            show_stmt.setInt(1, 32000);
                            show_stmt.executeUpdate();
                            LOGGER.info(show_stmt.getString(3));
                            done = show_stmt.getInt(2);
                            if (done == 1) {
                                break;
                            }
                        }
                    }
                });
                Query queryDisable = sessionFactory.getCurrentSession().createSQLQuery("call dbms_output.disable()");
                queryDisable.executeUpdate();
                LOGGER.debug("after DBMS_OUTPUT point cut");
            }
        }
    }
}