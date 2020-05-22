import java.sql.*;

public class OracleJDBCtimeouts {

    String dbConn = "jdbc:oracle:thin:@10.37.129.3:1521:XE";
    String dbUser = "system";
    String dbPass = "welcome1";

    Connection conn = null;
    CallableStatement cs = null;

    public void callORCL() throws Exception {
        callORCL(5, 0);
    }
    public void callORCL(int sleepSec) throws Exception {
        callORCL(sleepSec, 0);
    }
    public void callORCL(int sleepSec, int queryTimeout) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(dbConn, dbUser, dbPass);
        String plsqlSleep = "begin\n" + "DBMS_LOCK.sleep(" + sleepSec + ");\n" + "end;\n";
        cs = conn.prepareCall(plsqlSleep);
        cs.setQueryTimeout(queryTimeout);
        cs.execute();
        cs.close();
        conn.close();
    }

    public static void main(String[] args){

        //Part I. In band processing

        System.out.println("Test1. oracle.net.READ_TIMEOUT");
        System.out.println("------------------------------");
        OracleJDBCtimeouts test1 = new OracleJDBCtimeouts();
        System.setProperty("oracle.net.READ_TIMEOUT", "2000");
        //does not work on 11g
        try {
            test1.callORCL(5);
            System.out.println("Failed! Operation not stopped!");
        } catch (Exception e) {
            System.out.println("Success! Operation time out!");
            System.out.println("Exception:" + e.getClass());
            System.out.println("Message  :" + e.getMessage());
        }
        System.getProperties().remove("oracle.net.READ_TIMEOUT");

        System.out.println();
        System.out.println("Test2. oracle.jdbc.ReadTimeout");
        System.out.println("------------------------------");
        System.setProperty("oracle.jdbc.ReadTimeout", "2000");
        OracleJDBCtimeouts test2 = new OracleJDBCtimeouts();
        try {
            test2.callORCL(5);
            System.out.println("Failed! Operation not stopped!");
        } catch (Exception e) {
            System.out.println("Success! Operation time out!");
            System.out.println("Exception:" + e.getClass());
            //java.sql.SQLRecoverableException
            System.out.println("Message  :" + e.getMessage());
            //IO Error: Socket read timed out
        }
        System.getProperties().remove("oracle.jdbc.ReadTimeout");

        System.out.println();
        System.out.println("Test3. setQueryTimeout");
        System.out.println("----------------------");
        OracleJDBCtimeouts test3 = new OracleJDBCtimeouts();
        try {
            test3.callORCL(5,4);
            System.out.println("Failed! Operation not stopped!");
        } catch (Exception e) {
            System.out.println("Success! Operation time out!");
            System.out.println("Exception:" + e.getClass());
            //java.sql.SQLTimeoutException
            System.out.println("Message  :" + e.getMessage());
            //ORA-01013: user requested cancel of current operation
        } 

        System.out.println();
        System.out.println("Test4. oracle.jdbc.ReadTimeout < setQueryTimeout");
        System.out.println("-------------------------------------------------");
        OracleJDBCtimeouts test4 = new OracleJDBCtimeouts();
        System.setProperty("oracle.jdbc.ReadTimeout", "2000");
        try {
            test4.callORCL(5,4);
            System.out.println("Failed! Operation not stopped!");
        } catch (Exception e) {
            System.out.println("Success! Operation time out!");
            System.out.println("Exception:" + e.getClass());
            //java.sql.SQLRecoverableException
            System.out.println("Message  :" + e.getMessage());
            //IO Error: Socket read timed out
        } 
        System.getProperties().remove("oracle.jdbc.ReadTimeout");

        // Part II. out of band stop of processing

        class DBThread extends Thread {

            OracleJDBCtimeouts orclAccess;

            public void setOrclAccess(OracleJDBCtimeouts orclAccess) {
                this.orclAccess = orclAccess;
            }

            public void run() {
                try {
                    orclAccess.callORCL(5);
                    System.out.println("Failed! Operation not stopped!");
                } catch (Exception e) {
                    System.out.println("Success! Operation time out!");
                    System.out.println("Exception:" + e.getClass());
                    System.out.println("Message  :" + e.getMessage());
                }
            }
        }

        System.out.println();
        System.out.println("Test5. Thread.interrupt()");
        System.out.println("-------------------------");
        OracleJDBCtimeouts test5 = new OracleJDBCtimeouts();

        System.setProperty("oracle.jdbc.javaNetNio", "true");
        DBThread dbThread5 = new DBThread();
        dbThread5.setOrclAccess(test5);

        try {
            dbThread5.start();
            Thread.sleep(1000);            
            dbThread5.interrupt();  
            Thread.sleep(5000);
        } catch (Exception e) {}
        System.getProperties().remove("oracle.jdbc.javaNetNio");

        System.out.println();
        System.out.println("Test6. statement.cancel()");
        System.out.println("-------------------------");
        OracleJDBCtimeouts test6 = new OracleJDBCtimeouts();
        DBThread dbThread6 = new DBThread();
        dbThread6.setOrclAccess(test6);

        try {
            dbThread6.start();
            Thread.sleep(1000);            
            test6.cs.cancel();  
            Thread.sleep(5000);
        } catch (Exception e) {}

    }
}