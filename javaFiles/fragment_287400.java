public class HelloAgiScript extends BaseAgiScript {
public void service(AgiRequest request, AgiChannel channel) throws AgiException
{

    // Answer the channel...
    answer();

    // ...say hello and get DTMF data...
    String data = getData("welcome");

    // ...and hangup.
    hangup();
}