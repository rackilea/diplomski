** RunnableTask.Java
 * Created by Kirk on 10/29/2017.
 */

public class RunnableTask implements Callable<Boolean> {

private String testIp = "";
private Boolean is_Reachable = false;


public RunnableTask(String testIp) {
    this.testIp = testIp;
}

@Override
public Boolean call() throws Exception {
    try {
        PingResult pingResult = Ping.onAddress(this.testIp).setTimes(1).setTimeOutMillis(1500).doPing();

        if (pingResult.isReachable) {
            is_Reachable = true;
        }
    } catch (UnknownHostException e) {
        e.printStackTrace();
    }

    return is_Reachable;

  }
}