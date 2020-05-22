package my.package;
import javax.xml.ws.Endpoint;
import org.red5.server.adapter.ApplicationAdapter;
public class MyApplication extends ApplicationAdapter{
    @Override
    public boolean appStart (IScope app){
        Endpoint.publish(
            "http://localhost:8080/WebService/red5ws",
            new Red5WS(this));
        }
        return super.appStart();
    }
}