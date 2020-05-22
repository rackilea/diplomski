import java.sql.Connection;

import javax.naming.Context;
import javax.sql.DataSource;

public class Hello implements HelloMBean {

    private final Context envContext;

    public Hello(final Context envContext) {
        this.envContext = envContext;
        System.out.println("new hello " + envContext);
    }

    @Override
    public void sayHello() {
        System.out.println("sayHello()");

        try {
            final DataSource ds = 
                (DataSource) envContext.lookup("jdbc/TestDB");
            final Connection conn = ds.getConnection();
            System.out.println("   conn: " + conn);
            // more JDBC code
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}