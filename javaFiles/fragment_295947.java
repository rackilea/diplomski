import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Connection1 extends Thread {

    public static void main(String[] args) throws ClassNotFoundException,
    SQLException {
        // Number of max DB connection allowed
        int poolSize = 20;

        ExecutorService execService = Executors.newFixedThreadPool(poolSize);
        List<Future<String>> futureList = new ArrayList<Future<String>>();

        for (int i = 0; i < 500; i++) {
            System.out.println("Thread count " + i);
            Callable<String> worker = new StartTester();
            Future<String> future = execService.submit(worker);
            futureList.add(future);
        }
    }
}

class StartTester implements Callable<String> {
    @Override
    public String call() {
        try {
            connect();
            return "SUCCESS";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "FAILURE";
    }

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                "root", "esignal");
        System.out.println("con success " + con);
        con.close();
        System.out.println("con Closed " + con);
    }
}