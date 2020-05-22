import java.lang.management.ManagementFactory;
import java.util.concurrent.atomic.AtomicLong;

import javax.management.ObjectName;

// If jconsole doesn't see this app automatically, invoke the application with the following java flags, and connect
// 'remotely' via jconsole.
//
// -Dcom.sun.management.jmxremote
// -Dcom.sun.management.jmxremote.port=2222 (or whatever)
// -Dcom.sun.management.jmxremote.authenticate=false
// -Dcom.sun.management.jmxremote.ssl=false
public class TestServer implements TestServerMBean
{
    private final AtomicLong m_counter = new AtomicLong(0L);
    private final long m_startTimeMillis = System.currentTimeMillis();

    public void run() throws InterruptedException {
        while (true) {
            m_counter.incrementAndGet();
            Thread.sleep(5000);
        }
    }

    public long getFooCount() {
        return m_counter.get();
    }

    public void setFooCount(long val) {
        m_counter.set(val);
    }

    public long getUptimeMillis() {
        return System.currentTimeMillis() - m_startTimeMillis;
    }

    public void printStuff(String stuff) {
        System.out.println(stuff);
    }

    public static void main(String[] args) throws Exception {
        TestServer ts = new TestServer();
        ManagementFactory.getPlatformMBeanServer().registerMBean(ts, new ObjectName("myapp:service=MyServer"));
        ts.run();
    }
}