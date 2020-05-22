import java.io.PrintStream;
import org.apache.hadoop.hive.cli.CliDriver;
import org.apache.hadoop.hive.cli.CliSessionState;
import org.apache.hadoop.hive.common.LogUtils;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.session.SessionState;

public class RunHQLScript {

    private static class MyCliSessionState extends CliSessionState {
        public MyCliSessionState(HiveConf conf, String host, int port) {
            super(conf);
            this.host = host;
            this.port = port;
        }
    }

    public static void main(String[] args) throws Exception {

        LogUtils.initHiveLog4j();
        CliSessionState ss = new MyCliSessionState(new HiveConf(SessionState.class),
                "localhost", 10000);

        ss.in = System.in;
        ss.out = new PrintStream(System.out, true, "UTF-8");
        ss.err = new PrintStream(System.err, true, "UTF-8");
        ss.fileName = "file.q";  //HQL file

        SessionState.start(ss);
        ss.connect();
        CliDriver cli = new CliDriver();
        int processFile = cli.processFile(ss.fileName);
        System.out.println("return code: " +processFile);
        ss.close();
    }
}